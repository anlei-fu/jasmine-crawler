package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.constant.TaskStatus;
import com.jasmine.crawl.common.pojo.entity.CrawlTask;
import com.jasmine.crawl.common.pojo.entity.Crawler;
import com.jasmine.crawl.common.pojo.entity.DownSystemSite;
import com.jasmine.crawl.common.pojo.entity.Site;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private  DownSystemService downSystemService;

    @Autowired
    private  CookieService cookieService;

    @Autowired
    private  ProxyService proxyService;

    public void run() {
        info("----------------------------begin terminate task-------------------------------");
        List<CrawlTask>  tasks=null;
        try{
            tasks =crawlTaskService.getTasksToTerminate();
        }catch (Exception ex){
            error("terminate task failed",ex);
        }

        if(tasks.size()==0){
            info("no task need to terminate");
            return;
        }

        int succeed=0;
        int failed=0;
        int exception=0;
        for (final CrawlTask task :tasks){
            try{
                terminateTaskCore(task);
                succeed++;
            }catch (Exception ex){
                error(String.format("terminate task(%d) failed",task.getId()),ex);
                exception++;
            }
        }
    }

    private  void  terminateTaskCore(CrawlTask task){
        Site site =siteService.getById(task.getSiteId());
        if(!Objects.isNull(site))
            siteService.decreaseCurrentRunningTaskCountById(site.getId());

        DownSystemSite downSystemSite =downSystemSiteService.getById(task.getDownSiteId());
        if(!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCountById(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCountById(downSystemSite.getDownSystemId());
        }

        if(task.getProxyId()!=-1)
            proxyService.decreaseCurrentUseCountById(task.getProxyId());

        if(task.getCookieId()!=-1)
            cookieService.decreaseCurrentUseCountById(task.getCookieId());

        crawlerService.terminateTaskById(task.getId(),TaskStatus.TIMEOUT);

        Crawler crawler =crawlerService.getById(task.getCrawlerId());
        if(!Objects.isNull(crawler)) {
            crawlerService.updateConcurrencyById(
                    crawler.getId(),
                    crawler.getCurrentConcurrency() - site.getMaxConcurrency()
            );
        }

    }
}
