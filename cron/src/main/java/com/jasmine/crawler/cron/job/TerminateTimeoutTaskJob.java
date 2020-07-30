package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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
    private DownSystemService downSystemService;

    @Autowired
    private CookieService cookieService;

    @Autowired
    private ProxyService proxyService;

    @Autowired
    private  SiteAccountService siteAccountService;

    public void run() {
        info("----------------------------begin terminate task-------------------------------");
        List<CrawlTask> tasks = null;
        try {
            tasks = crawlTaskService.getTimeoutTasksToTerminate();
        } catch (Exception ex) {
            error("terminate task failed", ex);
        }

        if (tasks.size() == 0) {
            info("no task need to terminate");
            return;
        }

        int succeed = 0;
        int failed = 0;
        int exception = 0;
        for (final CrawlTask task : tasks) {
            try {
                terminateTaskCore(task);
                succeed++;
            } catch (Exception ex) {
                error(String.format("terminate task(%d) failed", task.getId()), ex);
                exception++;
            }
        }

        info(String.format(
                "finish terminate timeout tasks, [succeed:%d][failed:%d][exception:%d]",
                succeed,
                failed,
                exception)
        );
    }

    private void terminateTaskCore(CrawlTask task) {
        task =crawlTaskService.getForUpdate(task.getId());
        if(Objects.isNull(task)){
            info("task not exists");
            return;
        }

        if(task.getTaskStatus()!=TaskStatus.EXECUTING){
             info(String.format("incorrect task status %d",task.getTaskStatus()));
             return;
        }

        Site site = siteService.get(task.getSiteId());
        if (!Objects.isNull(site))
            siteService.decreaseCurrentRunningTaskCountById(site.getId());

        DownSystemSite downSystemSite = downSystemSiteService.get(task.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());
        }

        if (task.getProxyId() != -1)
            proxyService.decreaseCurrentUseCount(task.getProxyId());

        if (task.getCookieId() != -1) {
            cookieService.decreaseCurrentUseCount(task.getCookieId());
            Cookie cookie = cookieService.get(task.getCookieId());
            siteAccountService.decreaseCurrentUseCount(cookie.getAccountId());
        }

        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler)) {
            crawlerService.increaseCurrentConcurrency(
                    crawler.getId(),
                    -site.getMinuteSpeedLimit()
            );
        }

        crawlTaskService.terminateTimeoutTask(task.getId());

    }
}
