package com.jasmine.crawler.web.api.job;


import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.service.CrawlTaskService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskResultConsumeJob {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Scheduled(cron = "0 */1 * * * *")
    public void thread1() {
        run();
    }

    @Scheduled(cron = "0 */2 * * * *")
    public void thread2() {
        run();
    }

    @Scheduled(cron = "0 */3 * * * *")
    public void thread3() {
        run();
    }

    private void run() {
        RQueue<SaveTaskResultReq> queue = redissonClient.getQueue("task_result_queue");

        while (true) {
            try {
                SaveTaskResultReq req = queue.poll();
                crawlTaskService.saveTaskResult(req);
            } catch (Exception ex) {
                break;
            }
        }
    }
}
