package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.constant.DispatchResult;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.component.CrawlTaskTerminator;
import com.jasmine.crawler.cron.config.SystemConfig;
import com.jasmine.crawler.cron.pojo.req.CrawlTaskConfig;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class DispatchTaskJob extends LoggerSupport {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private ProxyService proxyService;

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

    @Autowired
    private CrawlTaskTerminator crawlTaskTerminator;

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
    @Scheduled(cron = "50/50 * * * * ?")
    public void run() {
        info("--------------begin dispatching crawl task----------------");

        // get task to run
        List<CrawlTaskConfig> configs = getTaskConfigsToRun();
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

    private List<CrawlTaskConfig> getTaskConfigsToRun() {
        List<CrawlTaskConfig> crawlTaskConfigs = null;
        try {
            crawlTaskConfigs = crawlTaskService.getTasksConfigsToDispatch();
        } catch (Exception ex) {
            error("call getTaskToRun failed", ex);
            return null;
        }

        info(String.format("got %d task to dispatch", crawlTaskConfigs.size()));

        if (crawlTaskConfigs.size() == 0) {
            info("no task need to run");
            return null;
        }

        return crawlTaskConfigs;
    }

    public boolean dispatchTaskCore(CrawlTaskConfig crawlTaskConfig) {
        boolean valid = false;

        // check site available
        Site site = siteService.get(crawlTaskConfig.getSiteId());
        valid = validate(
                site,
                crawlTaskConfig,
                DispatchResult.SITE_NOT_AVAILABLE,
                "site not available"
        );

        if (!valid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        // check down system site available
        DownSystemSite downSystemSite = downSystemSiteService.get(crawlTaskConfig.getDownSystemSiteId());
        valid = validate(
                site,
                crawlTaskConfig,
                DispatchResult.DOWN_SYSTEM_SITE_NOT_AVAILABLE,
                "down site not available"
        );

        if (!valid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        // check down system available
        DownSystem downSystem = downSystemService.get(downSystemSite.getId());
        valid = validate(
                site,
                crawlTaskConfig,
                DispatchResult.DOWN_SYSTEM_NOT_AVAILABLE,
                "down system not available"
        );

        if (!valid) {
            crawlTaskService.delete(crawlTaskConfig.getTaskId());
            return false;
        }

        Cookie cookie = null;
        // check and config cookie
        if (crawlTaskConfig.getCookieId() != BooleanFlag.NO_NEED) {
            cookie = cookieService.get(crawlTaskConfig.getCookieId());
            valid = validate(
                    cookie,
                    crawlTaskConfig,
                    DispatchResult.COOKIE_NOT_AVAILABLE,
                    "cookie not available"
            );

            if (!valid)
                return false;
        }

        // check and config proxy
        Proxy proxy = null;
        if (crawlTaskConfig.getProxyId() != BooleanFlag.NO_NEED) {
            proxy = proxyService.get(crawlTaskConfig.getProxyId());
            valid = validate(
                    site,
                    crawlTaskConfig,
                    DispatchResult.PROXY_NOT_AVAILABLE,
                    "proxy not available"
            );

            if (!valid)
                return false;

            crawlTaskConfig.setProxy(proxy);
        }

        // check and config crawler
        Crawler crawler = crawlerService.get(crawlTaskConfig.getCrawlerId());
        valid = validate(
                crawler,
                crawlTaskConfig,
                DispatchResult.CRAWLER_NOT_AVAILABLE,
                "crawler not available"
        );
        if (!valid)
            return false;

        // fetch task urls
        List<Url> urls = urlService.getUrlToExecuteForSite(
                crawlTaskConfig.getSiteId(),
                downSystemSite.getTaskUrlBatchCount()
        );

        if (urls.size() == 0) {
            validate(
                    null,
                    crawlTaskConfig,
                    DispatchResult.GET_URL_TO_RUN_FAILED,
                    "no url to run task"
            );
            return false;
        }

        crawlTaskConfig.setUrls(urls);

        // post crawler to run new task
        R resp = new R();
        try {
            // post crawler to run new task
            resp = restTemplate.postForObject(
                    String.format(
                            "http://%s:%d%s",
                            crawler.getIp(),
                            crawler.getPort(),
                            systemConfig.getCrawlerStartNewTaskPath()
                    ),
                    crawlTaskConfig,
                    R.class
            );
        } catch (Exception ex) {
            resp.setCode(500);
            resp.setMessage("failed");
            error(String.format("post crawler(%d) failed", crawler.getId()), ex);
        }

        if (!resp.isSuccess()) {
            validate(
                    null,
                    crawlTaskConfig,
                    DispatchResult.POST_CRAWLER_FAILED,
                    resp.getMessage()
            );

            return false;
        }

        dispatchSuccess(crawlTaskConfig, downSystemSite.getId());
        info(String.format("dispatch task(%d) success", crawlTaskConfig.getTaskId()));
        return true;
    }

    /**
     * Check is resource available or release all resource locked by bind job
     * add bind record and update bind status to 'wait'
     *
     * @param crawlTaskConfig
     * @param msg
     */
    private boolean validate(Object target, CrawlTaskConfig crawlTaskConfig, Integer dispatchStatus, String msg) {
        if (Objects.isNull(target)
                || ((target instanceof EnableStatusFeature)
                && ((EnableStatusFeature) target).getEnableStatus() == BooleanFlag.FALSE)
        ) {
            dispatchFailed(crawlTaskConfig, dispatchStatus, msg);
            info(String.format("dispatch task(%d) failed cause %s", crawlTaskConfig.getTaskId(), msg));
            return false;
        }

        return true;
    }

    /**
     * Release all resources that locked by bind job if dispatch failed
     *
     * @param crawlTaskConfig
     * @param dispatchResult
     * @param dispatchMsg
     */
    @Transactional
    public void dispatchFailed(CrawlTaskConfig crawlTaskConfig, Integer dispatchResult, String dispatchMsg) {

        CrawlTask task = crawlTaskService.get(crawlTaskConfig.getTaskId());
        crawlTaskTerminator.terminate(task);

        // add dispatch record
        DispatchRecord dispatchRecord = DispatchRecord.builder()
                .crawlTaskId(crawlTaskConfig.getTaskId())
                .dispatchResult(dispatchResult)
                .dispatchMsg(dispatchMsg)
                .build();
        dispatchRecordService.add(dispatchRecord);

        // update task dispatch status
        CrawlTask dispatchFailedTask = CrawlTask
                .builder()
                .id(crawlTaskConfig.getTaskId())
                .dispatchLastResult(dispatchResult)
                .dispatchLastMsg(dispatchMsg)
                .build();

        crawlTaskService.dispatchFailed(dispatchFailedTask);
    }

    public void dispatchSuccess(CrawlTaskConfig crawlTaskConfig, Integer downSystemSiteId) {
        DispatchRecord dispatchRecord = DispatchRecord.builder()
                .crawlTaskId(crawlTaskConfig.getTaskId())
                .dispatchResult(DispatchResult.SUCCESS)
                .dispatchMsg("success")
                .build();

        dispatchRecordService.add(dispatchRecord);
        crawlTaskService.dispatchSuccess(crawlTaskConfig.getTaskId(), downSystemSiteId);
    }

}
