package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.support.CounterProvider;
import com.jasmine.crawler.common.support.LoggerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class CounterCleanJob extends LoggerSupport {

    @Autowired
    private CounterProvider counterProvider;

    /**
     * To clear expired counters period
     *
     */
    @Scheduled(cron = "0 0 */2 * * *")
    public void Run() {
        info("execute counter clean job");
        int cleared = counterProvider.clean();
        info(String.format("clear %d counters", cleared));
    }
}
