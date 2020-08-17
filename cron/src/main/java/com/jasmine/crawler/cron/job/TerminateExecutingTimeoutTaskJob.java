package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.component.CrawlTaskTerminator;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TerminateExecutingTimeoutTaskJob extends LoggerSupport {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private CrawlTaskTerminator crawlTaskTerminator;

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
        int exception = 0;
        for (final CrawlTask task : tasks) {
            try {
                terminateTimeoutTaskCore(task);
                succeed++;
            } catch (Exception ex) {
                error(String.format("terminate task(%d) failed", task.getId()), ex);
                exception++;
            }
        }

        info(String.format(
                "finish terminate timeout tasks, [succeed:%d][exception:%d]",
                succeed,
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
    public void terminateTimeoutTaskCore(CrawlTask task) {
        crawlTaskTerminator.terminate(task);
        crawlTaskService.terminateExecuteTimeoutTask(task.getId());
    }

}
