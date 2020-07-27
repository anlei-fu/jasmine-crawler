package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import com.jasmine.crawler.cron.service.CrawlerService;
import com.jasmine.crawler.cron.service.ProxyService;
import com.jasmine.crawler.cron.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class TerminateTimeoutTaskJob extends LoggerSupport {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private CrawlerService crawlerService;

    @Autowired
    private ProxyService proxyService;

    public void run() {

    }
}
