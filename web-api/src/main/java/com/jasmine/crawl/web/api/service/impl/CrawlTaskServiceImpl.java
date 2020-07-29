package com.jasmine.crawl.web.api.service.impl;

import com.jasmine.crawl.common.constant.TaskStatus;
import com.jasmine.crawl.common.pojo.entity.*;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawl.web.api.mapper.CrawlTaskMapper;
import com.jasmine.crawl.web.api.pojo.req.SaveDataResultReq;
import com.jasmine.crawl.web.api.pojo.req.SaveUrlResultReq;
import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;
import com.jasmine.crawl.web.api.service.*;
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
    private SiteIpDelayMapService siteIpDelayMapService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private SiteCookieDelayMapService siteCookieDelayMapService;

    @Autowired
    private SiteAccountDelayService siteAccountDelayService;

    @Autowired
    private SiteAccountService siteAccountService;

    @Override
    public boolean saveTaskResult(TaskResultReq req) {

        saveUrls(req);
        saveData(req);

        try {
            terminateCrawTask(req);
        } catch (Exception ex) {

        }
        saveTaskResultCore(req);
        return false;
    }

    private void saveUrls(TaskResultReq req) {
        try {
            SaveUrlResultReq saveUrlResultReq = SaveUrlResultReq.builder()
                    .newUrls(req.getNewUrls())
                    .badUrls(req.getBadUrls())
                    .failedUrls(req.getFailedUrls())
                    .downSystemSiteId(req.getDownSystemSiteId())
                    .unStartUrls(req.getUnStartUrls())
                    .succeedUrls(req.getSucceedUrls())
                    .build();
            urlService.saveUrlResult(saveUrlResultReq);
        } catch (Exception ex) {

        }
    }

    private void saveData(TaskResultReq req) {
        try {
            SaveDataResultReq saveDataResultReq = SaveDataResultReq.builder().build();
            dataService.saveData(saveDataResultReq);
        } catch (Exception ex) {

        }
    }

    private void terminateCrawTask(TaskResultReq req) {

        // task removed
        CrawlTask task = crawlTaskMapper.getCrawlTaskForUpdateById(req.getTaskId());
        if (Objects.isNull(task)) {
            info("task removed");
            return;
        }

        // incorrect task status may have been processed by terminate task
        if (task.getTaskStatus() != TaskStatus.EXECUTING) {
            info(String.format("task status incorrect %d", req.getTaskStatus()));
            return;
        }

        // decrease  site current task count
        Site site = siteService.getById(task.getSiteId());
        siteService.decreaseCurrentRunningTaskCount(site.getId());

        // decrease down system and down system site concurrency
        DownSystemSite downSystemSite = downSystemSiteService.getById(task.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());
        }

        // decrease site account cookie concurrency
        Cookie cookie = null;
        SiteAccount siteAccount = null;
        if (task.getCookieId() != -1) {
            cookie = cookieService.getById(task.getCookieId());
            if (!Objects.isNull(cookie)) {
                cookieService.decreaseCurrentRunningTaskCount(cookie.getId());

                siteAccount = siteAccountService.get(cookie.getAccountId());
                if (!Objects.isNull(siteAccount))
                    siteAccountService.decreaseCurrentUseCount(siteAccount.getId());
            }
        }

        // decrease proxy use count
        Proxy proxy = null;
        if (task.getProxyId() != -1) {
            proxy = proxyService.getById(task.getProxyId());
            if (!Objects.isNull(proxy))
                proxyService.decreaseCurrentUseCount(proxy.getId());
        }

        // decrease crawler concurrency
        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler))
            crawlerService.decreaseCurrentConcurrencyById(task.getCrawlerId());

        // handle block result
        if (req.getTaskStatus() == TaskStatus.BLOCKED) {
            if (!Objects.isNull(proxy))
                proxyService.increaseBlockCount(proxy.getId());

            if (!Objects.isNull(cookie))
                cookieService.increaseBlockCount(cookie.getId());

            if (!Objects.isNull(siteAccount))
                siteAccountService.increaseBlockCount(siteAccount.getId());
        } else if (req.getTaskStatus() == TaskStatus.SUCCESS) {
            if (!Objects.isNull(proxy))
                proxyService.resetBlockCount(proxy.getId());

            if (!Objects.isNull(cookie))
                cookieService.resetBlockCount(cookie.getId());

            if (!Objects.isNull(siteAccount))
                siteAccountService.resetBlockCount(siteAccount.getId());
        } else {
            if (!Objects.isNull(proxy))
                proxyService.increaseBlockCount(proxy.getId());
        }

    }

    private void saveTaskResultCore(TaskResultReq req) {
        // update task

        CrawlTask crawlTaskToUpdate = CrawlTask.builder().build();
    }
}
