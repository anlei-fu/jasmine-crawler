package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.mapper.CrawlTaskMapper;
import com.jasmine.crawler.web.api.pojo.req.SaveDataResultReq;
import com.jasmine.crawler.web.api.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.web.api.pojo.req.TaskResultReq;
import com.jasmine.crawler.web.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CrawlTaskServiceImpl extends LoggerSupport implements CrawlTaskService {

    @Autowired
    private UrlService urlService;

    @Autowired
    private DataService dataService;

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

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
    private ProxyService proxyService;

//    @Autowired
//    private SiteCookieDelayMapService siteCookieDelayMapService;
//
//    @Autowired
//    private SiteAccountDelayService siteAccountDelayService;

    @Autowired
    private SiteAccountService siteAccountService;

    @Override
    public boolean saveTaskResult(TaskResultReq req) {
        saveUrls(req);
        saveData(req);

        try {
            finishCrawTask(req);
        } catch (Exception ex) {
            error(String.format("terminate task(%d) failed",req.getTaskId()),ex);
        }

        return true;
    }

    private void saveUrls(TaskResultReq req) {
        try {
            SaveUrlResultReq saveUrlResultReq = SaveUrlResultReq.builder()
                    .taskId(req.getTaskId())
                    .newUrls(req.getNewUrls())
                    .badUrls(req.getBadUrls())
                    .failedUrls(req.getFailedUrls())
                    .downSystemSiteId(req.getDownSystemSiteId())
                    .unStartUrls(req.getUnStartUrls())
                    .succeedUrls(req.getSucceedUrls())
                    .build();
            urlService.saveUrlResult(saveUrlResultReq);
        } catch (Exception ex) {
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    private void saveData(TaskResultReq req) {
        try {
            SaveDataResultReq saveDataResultReq = SaveDataResultReq.builder()
                    .data(req.getData())
                    .taskId(req.getTaskId())
                    .downSystemId(req.getDownSystemSiteId())
                    .build();
            dataService.saveData(saveDataResultReq);
        } catch (Exception ex) {
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    private void finishCrawTask(TaskResultReq req) {

        // task removed
        CrawlTask task = crawlTaskMapper.getCrawlTaskForUpdate(req.getTaskId());
        if (Objects.isNull(task)) {
            info("task removed");
            return;
        }

        // incorrect task status may have been processed by timeout termination job
        if (task.getTaskStatus() != TaskStatus.EXECUTING) {
            info(String.format("task status incorrect %d", req.getTaskStatus()));
            return;
        }



        // decrease down system and down system site concurrency
        DownSystemSite downSystemSite = downSystemSiteService.get(task.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());
        }

        // decrease site account cookie concurrency
        Cookie cookie = null;
        SiteAccount siteAccount = null;
        if (task.getCookieId() != -1) {
            cookie = cookieService.get(task.getCookieId());
            if (!Objects.isNull(cookie)) {
                cookieService.decreaseCurrentUseCount(cookie.getId());

                // decrease site account use count
                siteAccount = siteAccountService.get(cookie.getAccountId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.decreaseCurrentUseCount(siteAccount.getId());
            }
        }

        // decrease proxy use count
        Proxy proxy = null;
        if (task.getProxyId() != -1) {
            proxy = proxyService.get(task.getProxyId());
            if (!Objects.isNull(proxy))
                proxyService.decreaseCurrentUseCount(proxy.getId());
        }

        // decrease  site current task count
        Site site = siteService.get(task.getSiteId());
        // decrease crawler concurrency
        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler)&&!Objects.isNull(site))
            crawlerService.decreaseCurrentConcurrency(task.getCrawlerId(), site.getMinuteSpeedLimit());

        // handle block result
        if (req.getTaskStatus() != TaskStatus.SUCCESS) {

            // add block count when block
            if (!Objects.isNull(proxy))
                proxyService.increaseBlockCount(proxy.getId());

            if (!Objects.isNull(cookie)) {
                cookieService.increaseBlockCount(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.increaseBlockCount(siteAccount.getId());
            }

            if (!Objects.isNull(siteAccount))
                siteAccountService.increaseBlockCount(siteAccount.getId());

        } else {

            // clear block count when success
            if (!Objects.isNull(proxy))
                proxyService.resetBlockCount(proxy.getId());

            if (!Objects.isNull(cookie)) {
                cookieService.resetBlockCount(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccount.resetBlockCount(siteAccount.getId());
            }

            if (!Objects.isNull(siteAccount))
                siteAccountService.resetBlockCount(siteAccount.getId());
        }

        finishCrawlTask(req);
    }

    private void finishCrawlTask(TaskResultReq req) {
        // update task

        CrawlTask crawlTaskToUpdate = CrawlTask.builder()
                .id(req.getTaskId())
                .taskStatus(req.getTaskStatus())
                .averageSpeedOfAll(req.getAverageSpeedOfAll())
                .averageSpeedOfSuccess(req.getAverageSpeedOfSuccess())
                .meanSpeedOfSuccess(req.getMeanSpeedOfSuccess())
                .successUrlCount(req.getSucceedUrls().size())
                .failedUrlCount(req.getFailedUrls().size())
                .urlBadCount(req.getBadUrls().size())
                .newUrlCount(req.getNewUrls().size())
                .build();

        crawlerService.finishTask(crawlTaskToUpdate);
    }
}
