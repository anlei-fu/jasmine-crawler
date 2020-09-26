package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.BindResult;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.Counter;
import com.jasmine.crawler.common.support.CounterProvider;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.common.util.DateUtils;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private CounterProvider counterProvider;

    @Scheduled(cron = "0 0/1 * * * *")
    public void bindLevel1() {
        bindTask(1);
    }

    @Scheduled(cron = "32 0/3 * * * ?")
    public void bindLevel2() {
        bindTask(2);
    }

    @Scheduled(cron = "28 0/5 * * * ?")
    public void bindLevel3() {
        bindTask(3);
    }

    @Scheduled(cron = "45 0/10 * * * ?")
    public void bindLevel4() {
        bindTask(4);
    }

    /**
     * Bind task
     *
     * @param level
     */
    private void bindTask(Integer level) {
        info(String.format("-----------begin binding '%d' level task--------------", level));
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
                "bind '%d' level task finished, [succeed:%d][failed:%d][exception:%d]",
                level,
                succeed,
                failed,
                exception)
        );
    }

    /**
     * Bind task, whatever bind result is increase bind count
     * 1. check site exist, update site concurrency, task count,
     * 2. check down system exist, update site concurrency, task count,
     * 3. check down system site exist,update site concurrency, task count,
     * 4. find crawler for site, and update crawler current concurrency
     * 5. find cookie for site if need, and update cookie use count
     * 6. find proxy for site if need,and update proxy use count
     */
    private boolean bindTaskCore(CrawlTask taskToBind) {

        boolean valid;
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
        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
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

            // get available proxy with site ip check
            List<Proxy> proxies = proxyService.getProxyForSite(site.getId());
            for (Proxy p : proxies) {
                if (checkIp(site, p.getIp(), downSystemSite)) {
                    proxy = p;
                    break;
                }
            }

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
        Crawler crawler = null;
        List<Crawler> crawlers = crawlerService.getCrawlerForSite(site.getId(), downSystemSite.getTaskUrlMaxConcurrency(), withIp);
        if (withIp) {
            for (Crawler c : crawlers) {
                if (checkIp(site, crawler.getIp(), downSystemSite)) {
                    crawler = c;
                    break;
                }
            }
        } else {
            if (crawlers.size() != 0)
                crawler = crawlers.get(0);
        }

        valid = validate(
                crawler,
                taskToBind.getId(),
                BindResult.NO_CRAWLER_AVAILABLE,
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

    /**
     * To check is the ip available for site
     *
     * @param site
     * @param ip
     * @param downSystemSite
     * @return
     */
    private boolean checkIp(Site site, String ip, DownSystemSite downSystemSite) {

        // 10 minutes ip limit check
        if (site.getIp10MinuteSpeedLimit() != BooleanFlag.NO_NEED) {
            long dateKey = System.currentTimeMillis() % (DateUtils.ONE_DAY_MS * 10);
            long expire = DateUtils.ONE_MINUTE_MS * 10 - (System.currentTimeMillis() - dateKey);
            Counter tenMinuteLimitCounter = counterProvider.getCounter(
                    String.format("counter_%d_%s_%d", site.getId(), ip, dateKey),
                    site.getIp10MinuteSpeedLimit(),
                    (int) expire);

            if (tenMinuteLimitCounter.overMaxLimit(downSystemSite.getTaskUrlBatchCount()))
                return false;
        }

        // hour ip limit check
        if (site.getIpHourSpeedLimit() != BooleanFlag.NO_NEED) {
            long dateKey = System.currentTimeMillis() % (DateUtils.ONE_HOUR_MS);
            long expire = DateUtils.ONE_HOUR_MS - (System.currentTimeMillis() - dateKey);
            Counter hourLimitCounter = counterProvider.getCounter(
                    String.format("counter_%d_%s_%d", site.getId(), ip, dateKey),
                    site.getIpHourSpeedLimit(),
                    (int) expire);

            if (hourLimitCounter.overMaxLimit(downSystemSite.getTaskUrlBatchCount()))
                return false;
        }

        // day ip limit check
        if (site.getIpDaySpeedLimit() != BooleanFlag.NO_NEED) {
            long dateKey = System.currentTimeMillis() % DateUtils.ONE_DAY_MS;
            long expire = DateUtils.ONE_DAY_MS - (System.currentTimeMillis() - dateKey);
            Counter dayLimitCounter = counterProvider.getCounter(
                    String.format("counter_%d_%s_%d", site.getId(), ip, dateKey),
                    site.getIpDaySpeedLimit(),
                    (int) expire);

            if (dayLimitCounter.overMaxLimit(downSystemSite.getTaskUrlBatchCount()))
                return false;
        }

        return true;
    }

    /**
     * To validate is component available for task, if not available , add a failed binding record
     *
     * @param target
     * @param taskToBindId
     * @param bindResult
     * @param taskToUpdate
     * @param bindMsg
     * @return
     */
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

    /**
     * After bind success
     *
     * @param taskToBindId
     * @param crawlTaskToUpdate
     * @param site
     * @param downSystemSite
     * @param crawler
     * @param proxy
     * @param cookie
     */
    @Transactional
    public void bindSuccess(
            Integer taskToBindId,
            CrawlTask crawlTaskToUpdate,
            Site site,
            DownSystemSite downSystemSite,
            Crawler crawler,
            Proxy proxy,
            Cookie cookie
    ) {

        downSystemSiteService.increaseRunningTaskCount(downSystemSite.getId());
        downSystemService.increaseRunningTaskCount(downSystemSite.getDownSystemId());

        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
            cookieService.increaseCurrentUseCount(crawlTaskToUpdate.getId());
            siteAccountService.increaseCurrentUseCount(cookie.getAccountId());
        }

        if (site.getNeedUseProxy() == BooleanFlag.TRUE)
            proxyService.increaseCurrentUseCount(crawlTaskToUpdate.getId());

        // update crawler current concurrency
        crawlerService.changeCurrentConcurrency(
                crawler.getId(),
                downSystemSite.getTaskUrlMaxConcurrency()
        );

        // add delay ip
        if (site.getIpDelayTimeout() != BooleanFlag.NO_NEED) {
            SiteIpDelayMap siteIpDelayMap = SiteIpDelayMap.builder()
                    .ip(!Objects.isNull(proxy) ? proxy.getIp() : crawler.getIp())
                    .delayTimeoutTime(new Date(System.currentTimeMillis() + site.getIpDelayTimeout() * 1000 * 60))
                    .siteId(site.getId())
                    .build();
            siteIpDelayService.add(siteIpDelayMap);
        }

        // delay account cookie
        if (site.getNeedUseCookie() == BooleanFlag.TRUE) {
            if (site.getAccountDelayTimeout() != BooleanFlag.NO_NEED)
                siteAccountService.updateDelayTimeoutTime(cookie.getAccountId());

            if (site.getCookieDelayTimeout() != BooleanFlag.NO_NEED)
                cookieService.updateDelayTimeoutTime(cookie.getId());
        }

        // add bind record
        BindRecord record = BindRecord.builder().crawlTaskId(taskToBindId)
                .bindResult(BindResult.SUCCESS)
                .bindMsg("success")
                .build();

        bindRecordService.add(record);
        crawlTaskToUpdate.setTaskUrlConcurrency(downSystemSite.getTaskUrlMaxConcurrency());
        // update task bind status
        crawlTaskService.bindSuccess(crawlTaskToUpdate);
    }
}
