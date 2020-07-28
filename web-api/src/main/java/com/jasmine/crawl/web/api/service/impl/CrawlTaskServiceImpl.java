package com.jasmine.crawl.web.api.service.impl;

import com.jasmine.crawl.common.pojo.entity.*;
import com.jasmine.crawl.web.api.mapper.CrawlTaskMapper;
import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;
import com.jasmine.crawl.web.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class CrawlTaskServiceImpl implements CrawlTaskService {

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

    @Override
    public boolean saveTaskResult(TaskResultReq req) {
        return false;
    }

    private void terminateCrawTask(TaskResultReq req) {
        CrawlTask task = crawlTaskMapper.getCrawlTaskForUpdateById(req.getTaskId());
        if (Objects.isNull(task)) {

        }

        // check task status
        if (task.getTaskStatus() == 1) {

        }

        // decrease  site current task count
        Site site = siteService.getById(task.getSiteId());
        siteService.decreaseCurrentRunningTaskCount(site.getId());

        DownSystemSite downSystemSite = downSystemSiteService.getById(task.getDownSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());
        }

        if (task.getCookieId() != -1) {
            Cookie cookie = cookieService.getById(task.getCookieId());
            if (!Objects.isNull(cookie)) {

            }
        }

        if (task.getProxyId() != -1) {
            Proxy proxy = proxyService.getById(task.getProxyId());
            if (!Objects.isNull(proxy)) {

            }
        }

        crawlerService.decreaseCurrentConcurrencyById(task.getCrawlerId());

    }
}
