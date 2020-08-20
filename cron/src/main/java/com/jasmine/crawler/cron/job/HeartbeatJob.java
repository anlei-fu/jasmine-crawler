package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.common.pojo.entity.Heartbeat;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.config.SystemConfig;
import com.jasmine.crawler.cron.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class HeartbeatJob extends LoggerSupport {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CrawlerService crawlerService;

    /**
     * Send crawler a heartbeat to check is crawler still alive
     * 1. post crawler with masters info and file system host, master(self)
     * 2. update crawler heartbeat status
     * 3. the 'heartbeat-lost-count' smaller, the heartbeat rate more often
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void run() {
        info("-------------begin sending heartbeat---------------");
        List<Crawler> crawlers = null;
        try {
            crawlers = crawlerService.getCrawlersNeedHeartbeat();
        } catch (Exception ex) {
            error("call getCrawlerNeedHeartbeat failed", ex);
            return;
        }

        info(String.format("got %d crawler to send heartbeat", crawlers.size()));

        if (crawlers.size() == 0) {
            info("no crawler need to send heartbeat");
            return;
        }

        Heartbeat heartbeat = Heartbeat.builder()
                .master("")
                .masters(systemConfig.getMasters())
                .fileHost(systemConfig.getFileHost())
                .build();

        for (final Crawler crawler : crawlers) {
            try {
                sendHeartbeatCore(crawler, heartbeat);
            } catch (Exception ex) {
                error(
                        String.format(
                                "send heartbeat to crawler(%s) failed",
                                crawler.getId()
                        )
                        , ex
                );
            }
        }
    }

    private void sendHeartbeatCore(Crawler crawler, Heartbeat heartbeat) {

        // do post
        R resp = null;
        try {
            resp = restTemplate.postForObject(
                    String.format(
                            "http://%s:%d%s",
                            crawler.getIp(),
                            crawler.getPort(),
                            systemConfig.getCrawlerHeartbeatPath()
                    ),
                    heartbeat,
                    R.class
            );
        } catch (Exception ex) {
            error("post crawler failed", ex);
            resp = R.failed(500);
        }

        crawlerService.updateHeartbeatStatus(
                crawler.getId(),
                resp.isSuccess()
        );

        info(String.format(
                "send heartbeat to crawler(%d) ,and response code is %d",
                crawler.getId(),
                resp.getCode()
        ));
    }
}
