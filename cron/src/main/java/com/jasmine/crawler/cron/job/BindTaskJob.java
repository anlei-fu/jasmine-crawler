package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.BindResult;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class BindTaskJob extends LoggerSupport {

    @Autowired
    private SiteService siteService;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private BindRecordService bindRecordService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private DownSystemService downSystemService;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private SiteAccountService siteAccountService;

    @Autowired
    private SiteIpDelayService siteIpDelayService;

    //    @Scheduled(cron = "30/30 * * * * ?")
    public void run() {
        bindTask(1);
    }

    private void bindTask(Integer level) {
        info(String.format("-----------begin bind '%d' level task--------------", level));
        List<CrawlTask> tasks = null;
        try {
            tasks = crawlTaskService.getTasksToBind(level);
        } catch (Exception ex) {
            error("call getTaskToBind failed", ex);
            return;
        }

        info(String.format("got %d task to bind", tasks.size()));

        if (tasks.size() == 0) {
            info("no task need to bind");
            return;
        }

        int succeed = 0;
        int failed = 0;
        int exception = 0;
        for (final CrawlTask task : tasks) {
            try {
                boolean bindResult = bindTaskCore(task);
                if (bindResult) {
                    succeed++;
                } else {
                    failed++;
                }
            } catch (Exception ex) {
                error(String.format("bind task(%d) failed", task.getId()), ex);
                exception++;
            }
        }

        info(String.format(
                "finish bind '%d' level task, [succeed:%d][failed:%d][exception:%d]",
                level,
                succeed,
                failed,
                exception)
        );
    }

    /**
     * Bind task, whatever bind result increase bind count
     * 1. check site exist, update site concurrency, task count,
     * 2. check down system exist, update site concurrency, task count,
     * 3. check down system site exist,update site concurrency, task count,
     * 4. find crawler for site, and update crawler current concurrency
     * 5. find cookie for site if need, and update cookie use count
     * 6. find proxy for site if need,and update proxy use count
     */
    private boolean bindTaskCore(CrawlTask taskToBind) {

        boolean valid = false;
        CrawlTask crawlTaskToUpdate = new CrawlTask();
        crawlTaskToUpdate.setId(taskToBind.getId());
        crawlTaskToUpdate.setDownSystemSiteId(taskToBind.getDownSystemSiteId());

        // check site
        Site site = siteService.get(taskToBind.getSiteId());
        valid = validate(
                site,
                taskToBind.getId(),
                BindResult.SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "site not available"
        );

        // site has been removed
        if (!valid) {
            crawlTaskService.delete(taskToBind.getId());
            return false;
        }

        // check down system site
        DownSystemSite downSystemSite = downSystemSiteService.get(taskToBind.getDownSystemSiteId());
        valid = validate(
                downSystemSite,
                taskToBind.getId(),
                BindResult.DOWN_SYSTEM_SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystemSite not available"
        );

        if (!valid) {

            // down system site has been removed
            if (Objects.isNull(downSystemSite))
                crawlTaskService.delete(taskToBind.getId());

            return false;
        }

        // over down system site max concurrency
        if (downSystemSite.getTaskCurrentRunningCount() >= downSystemSite.getTaskMaxRunningCount()) {
            validate(
                    null,
                    taskToBind.getId(),
                    BindResult.OVER_DOWN_SYSTEM_SITE_MAX_CONCURRENCY,
                    crawlTaskToUpdate,
                    "over down system site max concurrency"
            );

            return false;
        }

        // check down system
        DownSystem downSystem = downSystemService.get(downSystemSite.getDownSystemId());
        valid = validate(
                downSystem,
                taskToBind.getId(),
                BindResult.DOWN_SYSTEM_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystem not available"
        );

        if (!valid) {

            // down system has been removed
            if (Objects.isNull(downSystem))
                crawlTaskService.delete(taskToBind.getId());

            return false;
        }

        // over down system max concurrency
        if (downSystem.getTaskCurrentRunningCount() >= downSystem.getTaskMaxRunningCount()) {
            validate(
                    null,
                    taskToBind.getId(),
                    BindResult.OVER_DOWN_SYSTEM_MAX_CONCURRENCY,
                    crawlTaskToUpdate,
                    "over down system max concurrency"
            );

            return false;
        }

        // get cookie for site if needed
        Cookie cookie = null;
        if (site.getCrawlNeedUseCookie() == BooleanFlag.TRUE) {
            cookie = cookieService.getCookieForSite(site.getId());
            valid = validate(
                    cookie,
                    taskToBind.getId(),
                    BindResult.NO_COOKIE_AVAILABLE,
                    crawlTaskToUpdate,
                    "no cookie available"
            );

            if (!valid)
                return false;

            taskToBind.setCookieId(cookie.getId());
        }

        // get proxy for site if needed
        Proxy proxy = null;
        if (site.getNeedUseProxy() == BooleanFlag.TRUE) {
            proxy = proxyService.getProxyForSite(site.getId());
            valid = validate(
                    proxy,
                    taskToBind.getId(),
                    BindResult.NO_PROXY_AVAILABLE,
                    crawlTaskToUpdate,
                    "no proxy available"
            );

            if (!valid)
                return false;

            crawlTaskToUpdate.setProxyId(proxy.getId());
        }

        // get crawler for site
        boolean withIp = proxy == null;
        Crawler crawler = crawlerService.getCrawlerForSite(site.getId(), withIp);
        valid = validate(
                crawler,
                taskToBind.getId(),
                BindResult.NO_PROXY_AVAILABLE,
                crawlTaskToUpdate,
                "no crawler available"
        );

        if (!valid)
            return false;

        crawlTaskToUpdate.setCrawlerId(crawler.getId());

        bindSuccess(taskToBind.getId(), crawlTaskToUpdate, site, downSystemSite, crawler, proxy, cookie);
        info(String.format("bind task(%d) succeed", taskToBind.getId()));
        return true;
    }

    private boolean validate(
            Object target,
            Integer taskToBindId,
            Integer bindResult,
            CrawlTask taskToUpdate,
            String bindMsg) {
        if (Objects.isNull(target)
                || ((target instanceof EnableStatusFeature)
                && ((EnableStatusFeature) target).getEnableStatus() == BooleanFlag.FALSE)
        ) {

            taskToUpdate.setBindLastResult(bindResult);
            taskToUpdate.setBindLastMsg(bindMsg);
            crawlTaskService.bindFailed(taskToUpdate);

            // add bind record
            BindRecord record = BindRecord.builder()
                    .crawlTaskId(taskToBindId)
                    .bindResult(bindResult)
                    .bindMsg(bindMsg)
                    .build();
            bindRecordService.add(record);

            info(String.format(
                    "bind task(%d) failed,cause %s",
                    taskToBindId,
                    bindMsg
            ));
            return false;
        }

        return true;
    }

    private void bindSuccess(
            Integer taskToBindId,
            CrawlTask crawlTaskToUpdate,
            Site site,
            DownSystemSite downSystemSite,
            Crawler crawler,
            Proxy proxy,
            Cookie cookie
    ) {

        downSystemSiteService.increaseRunningTaskCount(downSystemSite.getId());
        downSystemSiteService.decreaseCurrentBindCount(downSystemSite.getId());
        downSystemService.increaseRunningTaskCount(downSystemSite.getDownSystemId());

        if (site.getCrawlNeedUseCookie() == BooleanFlag.TRUE) {
            cookieService.increaseCurrentUseCount(crawlTaskToUpdate.getId());
            siteAccountService.increaseCurrentUseCount(cookie.getAccountId());
        }

        if (site.getNeedUseProxy() == BooleanFlag.TRUE)
            proxyService.increaseCurrentUseCount(crawlTaskToUpdate.getId());

        // update crawler current concurrency
        crawlerService.increaseCurrentConcurrency(
                crawler.getId(),
                site.getIpMinuteSpeedLimit()
        );

        // add delay ip
        if (site.getIpDelayTimeout() != BooleanFlag.NO_NEED) {
            SiteIpDelayMap siteIpDelayMap = SiteIpDelayMap.builder()
                    .ip(!Objects.isNull(proxy) ? proxy.getIp() : crawler.getIp())
                    .delayTimeoutTime(new Date(System.currentTimeMillis() + site.getIpDelayTimeout()))
                    .siteId(site.getId())
                    .build();
            siteIpDelayService.add(siteIpDelayMap);
        }

        // delay account cookie
        if (site.getCrawlNeedUseCookie() == BooleanFlag.TRUE) {
            if (site.getAccountDelayTimeout() != BooleanFlag.NO_NEED)
                siteAccountService.updateDelayTimeout(cookie.getAccountId());

            if (site.getCookieDelayTimeout() != BooleanFlag.NO_NEED)
                cookieService.updateDelayTimeout(cookie.getId());
        }

        // add bind record
        BindRecord record = BindRecord.builder().crawlTaskId(taskToBindId)
                .bindResult(BindResult.SUCCESS)
                .bindMsg("success")
                .build();

        bindRecordService.add(record);

        // update task bind status
        crawlTaskService.bindSuccess(crawlTaskToUpdate);
    }
}
