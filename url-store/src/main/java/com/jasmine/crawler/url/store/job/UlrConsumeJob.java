package com.jasmine.crawler.url.store.job;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.url.store.service.UrlService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class UlrConsumeJob extends LoggerSupport {

    private static final int URL_INSERT_BATCH_SIZE = 50;

    private static final int URL_UPDATE_BATCH_SIZE = 30;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UrlService urlService;

    /**
     * Save url result job
     * 1. update url status
     * 2. save new url
     * 3. increase down system site url total and finished
     * 4. increase down system site url total and finished
     * 5. increase site url total and finished
     *
     * @throws IOException
     */
    @Scheduled(cron = "*/30 * * * * ?")
    public void thread1() throws Exception {
        run();
    }

    @Scheduled(cron = "*/30 * * * * ?")
    public void thread2() throws Exception {
        run();
    }

    private void run() throws Exception {
        RQueue<SaveUrlResultReq> queue = redissonClient.getQueue("url_queue");

        info("------------begin url save job-----------------");

        while (true) {
            SaveUrlResultReq req = queue.poll();

            // no req n to save
            if (Objects.isNull(req)) {
                info("no url result poll to save");
                return;
            }

            info(String.format("begin save task %d url result", req.getTaskId()));
            try {
                urlService.saveTaskUrlResult(req);
                info(String.format("save task %d url result succeed", req.getTaskId()));
            } catch (Exception ex) {
                error(String.format("Save task %d url exceptional", req.getTaskId()), ex);
            }
        }
    }

}
