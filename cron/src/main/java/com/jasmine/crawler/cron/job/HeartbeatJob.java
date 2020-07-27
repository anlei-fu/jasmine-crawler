package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.api.model.R;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.constant.BooleanFlag;
import com.jasmine.crawler.cron.pojo.config.SystemConfig;
import com.jasmine.crawler.cron.pojo.entity.Crawler;
import com.jasmine.crawler.cron.pojo.req.Heartbeat;
import com.jasmine.crawler.cron.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
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
     */
    @Scheduled(cron = "*/6 * * * * ?")
    public void run() {
        info("-------------begin sending heartbeat---------------");
        List<Crawler> crawlers = null;
        try {
            crawlers = crawlerService.getCrawlerNeedHeartbeat();
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
        R resp = restTemplate.postForObject(
                String.format(
                        "%s:%d%s",
                        crawler.getIp(),
                        crawler.getPort(),
                        systemConfig.getCrawlerHeartbeatPath()
                ),
                heartbeat,
                R.class
        );

        // update crawler heartbeat
        Crawler crawlerToUpdate = new Crawler();

        crawlerToUpdate.setLastHeartbeatStatus(
                resp.isSuccess() ? BooleanFlag.TRUE : BooleanFlag.FALSE
        );
        crawlerToUpdate.setHeartbeatLost(crawler.getHeartbeatLost()+1);

        crawlerService.updateHeartbeatStatusById(crawler.getId(), crawlerToUpdate);

        info(String.format(
                "heartbeat crawler(%d) ,and response is %d",
                crawler.getId(),
                resp.getCode()
        ));
    }
}
