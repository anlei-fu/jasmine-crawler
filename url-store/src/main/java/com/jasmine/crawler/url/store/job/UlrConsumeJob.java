package com.jasmine.crawler.url.store.job;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.url.store.service.UrlResultFetcher;
import com.jasmine.crawler.url.store.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class UlrConsumeJob extends LoggerSupport {

    @Autowired
    private UrlResultFetcher urlResultFetcher;

    @Autowired
    private UrlService urlService;

    /**
     * Save url result job
     *
     * 1. update url status by page result code
     * 2. save new url
     * 3. add down system site url total and finished
     * 4. add down system site url total and finished
     * 5. add site url total and finished
     *
     * @throws IOException
     */
    @Scheduled(cron = "22/30 * * * * ?")
    public void thread1() throws Exception {
        run();
    }

    @Scheduled(cron = "2/25 * * * * ?")
    public void thread2() throws Exception {
        run();
    }

    @Scheduled(cron = "12/25 * * * * ?")
    public void thread3() throws Exception {
        run();
    }

    @Scheduled(cron = "42/25 * * * * ?")
    public void thread4() throws Exception {
        run();
    }

    private void run() throws Exception {

        info("------------begin url save job-----------------");

        while (true) {
            SaveUrlResultReq req = urlResultFetcher.fetch();

            // no req n to save
            if (Objects.isNull(req)) {
                info("no url result poll to save");
                return;
            }

            info(String.format("begin save task(%d) url result", req.getTaskId()));
            try {
                urlService.saveUrlResult(req);
                info(String.format("save task(%d) url result succeed", req.getTaskId()));
            } catch (Exception ex) {
                error(String.format("Save task(%d) url failed", req.getTaskId()), ex);
            }
        }
    }

}
