package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.constant.TaskResult;
import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.mapper.CrawlTaskMapper;
import com.jasmine.crawler.web.api.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.web.api.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.web.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Autowired
    private SiteAccountService siteAccountService;

    @Autowired
    private SiteIpBlockMapServiceImpl siteIpBlockMapService;

    @Override
    public boolean saveTaskResult(SaveTaskResultReq req) {
        saveUrls(req);

        Integer downSystemId = crawlTaskMapper.getDownSystemIdById(req.getTaskId());

        saveData(req, downSystemId);

        try {
            finishCrawTask(req);
        } catch (Exception ex) {
            error(String.format("terminate task(%d) failed", req.getTaskId()), ex);
        }

        return true;
    }

    private void saveUrls(SaveTaskResultReq req) {
        try {
            SaveUrlResultReq saveUrlResultReq = SaveUrlResultReq.builder()
                    .taskId(req.getTaskId())
                    .newUrls(req.getNewUrls())
                    .badUrls(req.getBadUrls())
                    .failedUrls(req.getFailedUrls())
                    .unStartUrls(req.getUnStartUrls())
                    .succeedUrls(req.getSucceedUrls())
                    .build();
            urlService.saveUrlResult(saveUrlResultReq);
        } catch (Exception ex) {
            // ignore url loss
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    private void saveData(SaveTaskResultReq req, Integer downSystemId) {
        try {
            SaveTaskDataReq saveDataResultReq = SaveTaskDataReq.builder()
                    .data(req.getData())
                    .taskId(req.getTaskId())
                    .downSystemId(downSystemId)
                    .build();
            dataService.saveData(saveDataResultReq);
        } catch (Exception ex) {
            // ignore data loss
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    @Transactional
    public void finishCrawTask(SaveTaskResultReq req) {

        // task removed
        CrawlTask task = crawlTaskMapper.getCrawlTaskForUpdate(req.getTaskId());
        if (Objects.isNull(task)) {
            info("task removed");
            return;
        }

        // incorrect task status may have been processed by timeout termination job
        if (task.getTaskStatus() != TaskStatus.WAIT_TO_DISPATCH) {
            info(String.format("task status incorrect %d", req.getTaskResult()));
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
        if (task.getCookieId() != BooleanFlag.NO_NEED) {
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
        if (task.getProxyId() != BooleanFlag.NO_NEED) {
            proxy = proxyService.get(task.getProxyId());
            if (!Objects.isNull(proxy))
                proxyService.decreaseCurrentUseCount(proxy.getId());
        }

        // decrease  site current task count
        Site site = siteService.get(task.getSiteId());
        // decrease crawler concurrency
        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler) && !Objects.isNull(site))
            crawlerService.decreaseCurrentConcurrency(task.getCrawlerId(), site.getIpMinuteSpeedLimit());

        // handle block result
        if (req.getTaskResult() == TaskResult.SUCCESS) {

            // clear block count when success
            if (!Objects.isNull(proxy))
                proxyService.resetBlockCount(proxy.getId());

            if (!Objects.isNull(cookie)) {
                cookieService.resetBlockCount(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.resetBlockCount(siteAccount.getId());
            }
        } else if (req.getTaskResult() == TaskResult.BLOCKED) {

            // add block count when block
            if (!Objects.isNull(proxy)) {
                proxyService.increaseBlockCount(proxy.getId());
            } else {
                SiteIpBlockMap siteIpBlockMap = SiteIpBlockMap.builder()
                        .ip(Objects.isNull(proxy) ? crawler.getIp() : proxy.getIp())
                        .siteId(site.getId())
                        .blockTimeoutTime(new Date(System.currentTimeMillis() + site.getIpBlockTimeout()))
                        .build();

                siteIpBlockMapService.add(siteIpBlockMap);
            }

            if (!Objects.isNull(cookie)) {
                cookieService.increaseBlockCount(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.increaseBlockCount(siteAccount.getId());
            }
        }

        finishCrawlTask(req);
    }

    private void finishCrawlTask(SaveTaskResultReq req) {
        // update task

        CrawlTask crawlTaskToUpdate = CrawlTask.builder()
                .id(req.getTaskId())
                .taskResult(req.getTaskResult())
                .averageSpeedOfAll(req.getAverageSpeedOfAll())
                .averageSpeedOfSuccess(req.getAverageSpeedOfSuccess())
                .meanSpeedOfSuccess(req.getMeanSpeedOfSuccess())
                .urlSuccessCount(req.getSucceedUrls().size())
                .urlFailedCount(req.getFailedUrls().size())
                .urlBadCount(req.getBadUrls().size())
                .urlNewCount(req.getNewUrls().size())
                .urlTotalCount(req.getUrlTotal())
                .build();
        crawlTaskMapper.finishTask(crawlTaskToUpdate);
    }
}
