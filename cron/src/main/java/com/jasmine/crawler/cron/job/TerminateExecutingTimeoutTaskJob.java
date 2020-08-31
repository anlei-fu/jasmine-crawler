package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.constant.TaskStatus;
import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.component.CrawlTaskTerminator;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
public class TerminateExecutingTimeoutTaskJob extends LoggerSupport {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private CrawlTaskTerminator crawlTaskTerminator;

    @Scheduled(cron = "30/30 * * * * ?")
    public void run() {
        info("----------------------------begin terminate timeout task-------------------------------");
        List<CrawlTask> tasks = null;
        try {
            tasks = crawlTaskService.getTimeoutTasksToTerminate();
        } catch (Exception ex) {
            error("call terminate task failed", ex);
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
                "terminate executing timeout tasks finished, [succeed:%d][exception:%d]",
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
        CrawlTask crawlTask = crawlTaskService.getForUpdate(task.getId());
        if (Objects.isNull(crawlTask) || crawlTask.getTaskStatus() != TaskStatus.EXECUTING)
            return;

        crawlTaskTerminator.terminate(task,true,true);
        crawlTaskService.terminateExecuteTimeoutTask(task.getId());
    }

}
