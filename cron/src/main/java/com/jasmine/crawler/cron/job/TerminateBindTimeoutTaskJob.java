package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.component.CrawlTaskTerminator;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TerminateBindTimeoutTaskJob extends LoggerSupport {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private CrawlTaskTerminator crawlTaskTerminator;

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
        crawlTaskTerminator.terminate(task);
        crawlTaskService.bindTimeout(task.getId());
    }
}
