package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.BindResult;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.*;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
public class TerminateExecutingTimeoutTaskJob extends LoggerSupport {

    @Autowired
    private BindRecordService bindRecordService;

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
    private SiteAccountService siteAccountService;

    public void run() {
        info("----------------------------begin terminate timeout task-------------------------------");
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
                if (terminateTimeoutTaskCore(task)) {
                    succeed++;
                } else {
                    failed++;
                }

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

    /**
     * Release all resources that task locked and update task status to
     * 'execute timeout'
     *
     * @param task
     */
    @Transactional
    public boolean terminateTimeoutTaskCore(CrawlTask task) {
        task = crawlTaskService.getForUpdate(task.getId());
        if (Objects.isNull(task)) {
            info("task not exists");
            return false;
        }

        if (task.getTaskStatus() != TaskStatus.EXECUTING) {
            info(String.format("incorrect task status %d", task.getTaskStatus()));
            return false;
        }

        DownSystemSite downSystemSite = downSystemSiteService.get(task.getDownSystemSiteId());
        if (!Objects.isNull(downSystemSite)) {
            downSystemSiteService.decreaseCurrentRunningTaskCount(downSystemSite.getId());
            downSystemService.decreaseCurrentRunningTaskCount(downSystemSite.getDownSystemId());
        }

        if (task.getProxyId() != BooleanFlag.NO_NEED)
            proxyService.decreaseCurrentUseCount(task.getProxyId());

        if (task.getCookieId() != BooleanFlag.NO_NEED) {
            cookieService.decreaseCurrentUseCount(task.getCookieId());
            Cookie cookie = cookieService.get(task.getCookieId());
            siteAccountService.decreaseCurrentUseCount(cookie.getAccountId());
        }

        Site site = siteService.get(task.getSiteId());
        Crawler crawler = crawlerService.get(task.getCrawlerId());
        if (!Objects.isNull(crawler)) {
            crawlerService.increaseCurrentConcurrency(
                    crawler.getId(),
                    -site.getIpMinuteSpeedLimit()
            );
        }

        crawlTaskService.terminateTimeoutTask(task.getId());
        return true;
    }

    /**
     * Terminate the task that over max bind time
     */
    public void terminateBindTimeoutTask() {
        info("------------------------begin terminate bind timeout task---------------------");
        List<CrawlTask> tasks = null;
        try {
            tasks = crawlTaskService.getBindTimeoutTasks();
        } catch (Exception ex) {
            error("call getBindTimeoutTasks failed", ex);
        }

        info(String.format("got %d task to terminate", tasks.size()));
        if (tasks.size() == 0) {
            info("no task to terminate");
        }

        int success = 0;
        int exception = 0;
        for (final CrawlTask task : tasks) {
            try {
                terminateBindTimeoutTaskCore(task);
                success++;
            } catch (Exception ex) {
                error(String.format("terminate task(%) failed", task.getId()), ex);
                exception++;
            }
        }

        info(String.format("finish job [success:%d][exception:%d]", success, exception));
    }

    @Transactional
    public void terminateBindTimeoutTaskCore(CrawlTask task) {
        BindRecord record = BindRecord.builder()
                .crawlTaskId(task.getId())
                .bindResult(BindResult.DOWN_SYSTEM_NOT_AVAILABLE)
                .bindMsg("bind timeout")
                .build();

        bindRecordService.add(record);

        crawlTaskService.bindTimeout(task.getId());
    }
}
