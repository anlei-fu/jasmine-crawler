package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.api.resp.R;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.constant.BindStatus;
import com.jasmine.crawler.cron.constant.BooleanFlag;
import com.jasmine.crawler.cron.constant.DispatchStatus;
import com.jasmine.crawler.cron.constant.TaskStatus;
import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawler.cron.pojo.config.SystemConfig;
import com.jasmine.crawl.common.pojo.entity.*;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class DispatchTaskJob extends LoggerSupport {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private SiteBlockRuleService siteBlockRuleService;

    @Autowired
    private UrlService urlService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private DownSystemService downSystemService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private DispatchRecordService dispatchRecordService;

    /**
     * Dispatch crawl task to crawler to run
     * 1. check site available
     * 2. check down site available
     * 3. check down system available
     * 4. check crawler available
     * 5. check proxy available
     * 6. check cookie available
     * <p>
     * TODO: are these checks required ? binding job has already done check once
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void run() {
        info("--------------begin dispatching crawl task----------------");
        // get task to run
        List<CrawlTaskConfig> configs = getTaskConfigToRun();
        if (Objects.isNull(configs))
            return;

        int succeed = 0;
        int failed = 0;
        int exception = 0;
        for (final CrawlTaskConfig crawlTaskConfig : configs) {
            try {

                boolean dispatchResult = dispatchTaskCore(crawlTaskConfig);
                if (dispatchResult) {
                    succeed++;
                } else {
                    failed++;
                }
            } catch (Exception ex) {
                exception++;
                error(String.format(
                        "dispatch task(%d) failed",
                        crawlTaskConfig.getTaskId()),
                        ex
                );
            }
        }

        info(String.format(
                "dispatch task finished, [succeed:%d][failed:%d][exception:%d]",
                succeed,
                failed,
                exception)
        );
    }

    private List<CrawlTaskConfig> getTaskConfigToRun() {
        List<CrawlTaskConfig> crawlTaskConfigs = null;
        try {
            crawlTaskConfigs = crawlTaskService.getTasksConfigsToDispatch();
        } catch (Exception ex) {
            error("call getTaskToRun failed", ex);
            return null;
        }

        if (crawlTaskConfigs.size() == 0) {
            info("no task need to run");
            return null;
        }

        return crawlTaskConfigs;
    }

    private boolean dispatchTaskCore(CrawlTaskConfig crawlTaskConfig) {
        boolean isInvalid = false;

        // check site available
        Site site = siteService.get(crawlTaskConfig.getSiteId());
        isInvalid = checkDispatch(
                site,
                crawlTaskConfig,
                DispatchStatus.SITE_NOT_AVAILABLE,
                "site not available"
        );
        if (isInvalid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        // check down system site available
        DownSystemSite downSystemSite = downSystemSiteService.get(crawlTaskConfig.getDownSystemSiteId());
        isInvalid = checkDispatch(
                site,
                crawlTaskConfig,
                DispatchStatus.DOWN_SITE_NOT_AVAILABLE,
                "down site not available"
        );
        if (isInvalid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        // check down system available
        DownSystem downSystem = downSystemService.get(downSystemSite.getId());
        isInvalid = checkDispatch(
                site,
                crawlTaskConfig,
                DispatchStatus.DOWN_SYSTEM_NOT_AVAILABLE,
                "down system not available"
        );
        if (isInvalid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        // check and config proxy
        if (crawlTaskConfig.getProxyId() != -1) {
            Proxy proxy = proxyService.get(crawlTaskConfig.getProxyId());
            isInvalid = checkDispatch(
                    site,
                    crawlTaskConfig,
                    DispatchStatus.PROXY_NOT_AVAILABLE,
                    "proxy not available"
            );

            if (isInvalid)
                return false;

            crawlTaskConfig.setProxy(proxy);
        }

        // check and config cookie
        if (crawlTaskConfig.getCookieId() != -1) {
            Cookie cookie = cookieService.get(crawlTaskConfig.getCookieId());
            isInvalid = checkDispatch(
                    cookie,
                    crawlTaskConfig,
                    DispatchStatus.COOKIE_NOT_AVAILABLE,
                    "cookie not available"
            );

            if (isInvalid)
                return false;
        }

        // check and config crawler
        Crawler crawler = crawlerService.get(1);
        isInvalid = checkDispatch(
                crawler,
                crawlTaskConfig,
                DispatchStatus.CRAWLER_NOT_AVAILABLE,
                "crawler not available"
        );
        if (isInvalid)
            return false;

        // config block rules
        List<SiteUrlCheckRule> rules = siteBlockRuleService.getRuleBySite(crawlTaskConfig.getSiteId());
        crawlTaskConfig.setRules(rules);

        // config task urls
        List<Url> urls = urlService.getUrlToExecuteBySite(
                crawlTaskConfig.getSiteId(),
                site.getTaskBatchCount()
        );

        if (urls.size() == 0) {
            checkDispatch(
                    null,
                    crawlTaskConfig,
                    DispatchStatus.GET_URL_TO_RUN_FAILED,
                    "no url get to run task"
            );
            return false;
        }

        // post crawler to run new task
        R resp = restTemplate.postForObject(
                String.format(
                        "%s:%d%s",
                        crawler.getIp(),
                        crawler.getPort(),
                        systemConfig.getCrawlerStartNewTaskPath()
                ),
                crawlTaskConfig,
                R.class
        );

        if (!resp.isSuccess()) {
            checkDispatch(
                    null,
                    crawlTaskConfig,
                    BindStatus.FAILED,
                    "post crawler failed"
            );
            return false;
        }

        CrawlTask crawlTaskToUpdate = CrawlTask
                .builder()
                .dispatchStatus(DispatchStatus.SUCCESS)
                .lastDispatchTime(new Date())
                .taskStartTime(new Date())
                .taskStatus(TaskStatus.EXECUTING)
                .build();
        crawlTaskService.update(crawlTaskConfig.getTaskId(),crawlTaskToUpdate);

        return true;
    }

    /**
     * Update task bind failed
     * 1. decrease crawler current concurrency
     * 2. decrease proxy current use count  if use proxy
     * 3. decrease cookie current use count if use cookie
     *
     * @param crawlTaskConfig
     * @param msg
     */
    private boolean checkDispatch(Object target, CrawlTaskConfig crawlTaskConfig, Integer dispatchStatus, String msg) {
        if (Objects.isNull(target)
                || ((target instanceof EnableStatusFeature)
                && ((EnableStatusFeature) target).getEnableStatus() == BooleanFlag.FALSE)
        ) {
            dispatchRecordService.addRecord(
                    crawlTaskConfig.getTaskId(),
                    dispatchStatus,
                    String.format("cause %s not available", msg)
            );

            dispatchFailed(crawlTaskConfig);

            CrawlTask crawlTaskToUpdate = CrawlTask
                    .builder()
                    .bindStatus(BindStatus.WAIT)
                    .dispatchStatus(dispatchStatus)
                    .build();
            crawlTaskService.update(crawlTaskConfig.getTaskId(), crawlTaskToUpdate);
        }

        return true;
    }

    private void dispatchFailed(CrawlTaskConfig crawlTaskConfig) {
        Site site = siteService.get(crawlTaskConfig.getSiteId());
        if (!Objects.isNull(site)) {
            siteService.decreaseCurrentRunningTaskCountById(site.getId());

            Crawler crawler = crawlerService.get(crawlTaskConfig.getCrawlerId());
            if (!Objects.isNull(crawler)) {
                crawlerService.increaseCurrentConcurrency(
                        crawler.getId(),
                        - site.getMaxConcurrency()
                );
            }
        }

        DownSystemSite downSystemSite = downSystemSiteService.get(crawlTaskConfig.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCountById(downSystemSite.getId());
            DownSystem downSystem = downSystemService.get(downSystemSite.getDownSystemId());
            if (!Objects.isNull(downSystem))
                downSystemService.decreaseCurrentRunningTaskCount(downSystem.getId());
        }

        if (crawlTaskConfig.getCookieId() != -1)
            cookieService.decreaseCurrentUseCount(crawlTaskConfig.getCookieId());

        if (crawlTaskConfig.getProxyId() != -1)
            proxyService.decreaseCurrentUseCount(crawlTaskConfig.getProxyId());

    }
}
