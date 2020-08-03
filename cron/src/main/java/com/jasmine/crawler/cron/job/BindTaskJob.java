package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.BindStatus;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
    private  SiteAccountService siteAccountService;

    @Scheduled(cron = "30/30 * * * * ?")
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

        boolean isInvalid = false;
        CrawlTask crawlTaskToUpdate = new CrawlTask();

        // check site
        Site site = siteService.get(taskToBind.getSiteId());
        isInvalid = checkIsComponentInvalid(
                site,
                taskToBind.getId(),
                BindStatus.SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "site not available"
        );

        // site has been removed
        if (isInvalid) {
            crawlTaskService.delete(taskToBind.getId());
            return false;
        }

        // check down system site
        DownSystemSite downSystemSite = downSystemSiteService.get(taskToBind.getDownSystemSiteId());
        isInvalid = checkIsComponentInvalid(
                downSystemSite,
                taskToBind.getId(),
                BindStatus.DOWN_SYSTEM_SITE_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystemSite not available"
        );

        if (isInvalid) {

            // down system site has been removed
            if (Objects.isNull(downSystemSite))
                crawlTaskService.delete(taskToBind.getId());

            return false;
        }

        // check down system
        DownSystem downSystem = downSystemService.get(downSystemSite.getDownSystemId());
        isInvalid = checkIsComponentInvalid(
                downSystem,
                taskToBind.getId(),
                BindStatus.DOWN_SYSTEM_NOT_AVAILABLE,
                crawlTaskToUpdate,
                "downSystem not available"
        );

        if (isInvalid) {

            // down system has been removed
            if (Objects.isNull(downSystem))
                crawlTaskService.delete(taskToBind.getId());

            return false;
        }

        // find and check cookie
        Cookie cookie =null;
        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
            cookie = cookieService.getCookieForSite(site.getId());
            isInvalid = checkIsComponentInvalid(
                    cookie,
                    taskToBind.getId(),
                    BindStatus.NO_COOKIE_AVAILABLE,
                    crawlTaskToUpdate,
                    "no cookie available"
            );

            if (isInvalid)
                return false;

            taskToBind.setCookieId(cookie.getId());
        }

        // find and check proxy
        if (site.getNeedUseProxy() == BooleanFlag.TRUE) {
            Proxy proxy = proxyService.getProxyForSite(site.getId());
            isInvalid = checkIsComponentInvalid(
                    proxy,
                    taskToBind.getId(),
                    BindStatus.NO_PROXY_AVAILABLE,
                    crawlTaskToUpdate,
                    "no proxy available"
            );

            if (isInvalid)
                return false;

            crawlTaskToUpdate.setProxyId(proxy.getId());
        }

        // find crawler and check crawler
        Crawler crawler = crawlerService.getCrawlerForSite(site.getId());
        isInvalid = checkIsComponentInvalid(
                crawler,
                taskToBind.getId(),
                BindStatus.NO_PROXY_AVAILABLE,
                crawlTaskToUpdate,
                "no crawler available"
        );

        if (isInvalid)
            return false;

        crawlTaskToUpdate.setCrawlerId(crawler.getId());

        bindSuccess(taskToBind.getId(), crawlTaskToUpdate, site, downSystemSite, crawler,cookie);
        info(String.format("bind task(%d) succeed", taskToBind.getId()));
        return true;
    }

    private boolean checkIsComponentInvalid(
            Object target,
            Integer taskToBindId,
            Integer bindStatus,
            CrawlTask taskToUpdate,
            String msg) {
        if (Objects.isNull(target)
                || ((target instanceof EnableStatusFeature)
                && ((EnableStatusFeature) target).getEnableStatus() == BooleanFlag.FALSE)
        ) {
            taskToUpdate.setBindLastStatus(bindStatus);
            taskToUpdate.setBindLastMsg(msg);
            crawlTaskService.bindFailed(taskToUpdate);

            // add bind record
            BindRecord record = BindRecord.builder()
                    .crawlTaskId(taskToBindId)
                    .bindStatus(bindStatus)
                    .bindMsg(msg)
                    .build();
            bindRecordService.add(record);

            info(String.format(
                    "bind task(%d) failed,cause %s",
                    taskToBindId,
                    msg
            ));
            return true;
        }

        return false;
    }

    private void bindSuccess(
            Integer taskToBindId,
            CrawlTask crawlTaskToUpdate,
            Site site,
            DownSystemSite downSystemSite,
            Crawler crawler,
            Cookie cookie
    ) {

        downSystemSiteService.increaseRunningTaskCount(downSystemSite.getDownSystemId());
        downSystemService.increaseRunningTaskCount(downSystemSite.getId());

        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
            cookieService.increaseCurrentUseCount(crawlTaskToUpdate.getId());
            siteAccountService.increaseCurrentUseCount(cookie.getAccountId());
        }

        if (site.getNeedUseProxy() == BooleanFlag.TRUE)
            proxyService.increaseCurrentUseCount(crawlTaskToUpdate.getId());

        // update crawler current concurrency
        crawlerService.increaseCurrentConcurrency(
                crawler.getId(),
                site.getMinuteSpeedLimit()
        );

        // add bind record
        BindRecord record = BindRecord.builder().crawlTaskId(taskToBindId)
                .bindStatus(BindStatus.SUCCESS)
                .bindMsg("success")
                .build();
        bindRecordService.add(record);

        // update task bind status

        boolean result = crawlTaskService.bindSuccess(taskToBindId);
    }
}
