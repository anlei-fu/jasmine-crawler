package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.constant.PageResult;
import com.jasmine.crawler.common.constant.TaskResult;
import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.mapper.CrawlTaskMapper;
import com.jasmine.crawler.web.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
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
        try {
            finishCrawTask(req);
            Integer downSystemId = crawlTaskMapper.getDownSystemIdById(req.getTaskId());
            saveData(req, downSystemId);
            saveUrls(req,downSystemId);
        } catch (Exception ex) {
            error(String.format("terminate task(%d) failed", req.getTaskId()), ex);
        }
        return true;
    }

    private void saveData(SaveTaskResultReq req, Integer downSystemId) {
        try {

            List<String> data = new LinkedList<>();
            req.getPageResults().stream().forEach(result -> {
                if (result.getPageResult() == PageResult.SUCCESS)
                    data.add(result.getData());
            });

            SaveTaskDataReq saveDataResultReq = SaveTaskDataReq.builder()
                    .downSystemId(downSystemId)
                    .taskId(req.getTaskId())
                    .data(data)
                    .build();
            dataService.saveData(saveDataResultReq);
        } catch (Exception ex) {
            // ignore data loss
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    private void saveUrls(SaveTaskResultReq req,Integer downSystemSiteId) {
        try {
            req.getPageResults().stream().forEach(r -> {
                r.setData(null);
            });

            SaveUrlResultReq saveUrlResultReq = SaveUrlResultReq.builder()
                    .pageResults(req.getPageResults())
                    .taskId(req.getTaskId())
                    .downSystemSiteId(downSystemSiteId)
                    .build();
            urlService.saveUrlResult(saveUrlResultReq);
        } catch (Exception ex) {
            // ignore url loss
            error(String.format("save url failed ,task id is %d", req.getTaskId()), ex);
        }
    }

    @Transactional
    public boolean finishCrawTask(SaveTaskResultReq req) {

        // lock and check task status
        CrawlTask task = crawlTaskMapper.getCrawlTaskForUpdate(req.getTaskId());
        if (Objects.isNull(task)) {
            info("task removed");
            return false;
        }

        // incorrect task status may have been processed by timeout termination job
        if (task.getTaskStatus() != TaskStatus.EXECUTING) {
            info(String.format("task status incorrect %d", req.getTaskResult()));
            return false;
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

        // decrease crawler concurrency
        Site site = siteService.get(task.getSiteId());
        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler) )
            crawlerService.decreaseCurrentConcurrency(task.getCrawlerId(), downSystemSite.getTaskUrlMaxConcurrency());

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
        } else if (req.getTaskResult() == TaskResult.IP_BLOCKED) {
            SiteIpBlockMap siteIpBlockMap = SiteIpBlockMap.builder()
                    .ip(Objects.isNull(proxy) ? crawler.getIp() : proxy.getIp())
                    .siteId(site.getId())
                    .blockTimeoutTime(new Date(System.currentTimeMillis() + site.getIpBlockTimeout()))
                    .build();

            siteIpBlockMapService.add(siteIpBlockMap);

        } else if (req.getTaskResult() == TaskResult.ACCOUNT_BLOCKED) {
            if (!Objects.isNull(cookie)) {
                cookieService.disable(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.block(siteAccount.getId());
            }
        } else {
            if (!Objects.isNull(proxy))
                proxyService.increaseBlockCount(proxy.getId());

            if (!Objects.isNull(cookie)) {
                cookieService.increaseBlockCount(cookie.getId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.increaseBlockCount(siteAccount.getId());
            }
        }

        finishCrawlTask(req);

        return true;
    }

    private void finishCrawlTask(SaveTaskResultReq req) {
        int success = 0;
        int fail = 0;
        int bad = 0;
        int _new = 0;
        for (final com.jasmine.crawler.common.pojo.dto.PageResult pr : req.getPageResults()) {
            if (pr.getPageResult() == PageResult.SUCCESS) {
                success++;
                _new += pr.getNewUrls().size();
            } else if (pr.getPageResult() == PageResult.BAD) {
                bad++;
            } else {
                fail++;
            }
        }

        CrawlTask crawlTaskToUpdate = CrawlTask.builder()
                .id(req.getTaskId())
                .taskResult(req.getTaskResult())
                .taskMsg(req.getMsg())
                .averageSpeedOfAll(req.getAverageSpeedOfAll())
                .averageSpeedOfSuccess(req.getAverageSpeedOfSuccess())
                .medianSpeedOfSuccess(req.getMedianSpeedOfSuccess())
                .urlSuccessCount(success)
                .urlFailedCount(fail)
                .urlBadCount(bad)
                .urlNewCount(_new)
                .urlTotalCount(req.getUrlTotal())
                .build();
        crawlTaskMapper.finishTask(crawlTaskToUpdate);
    }
}
