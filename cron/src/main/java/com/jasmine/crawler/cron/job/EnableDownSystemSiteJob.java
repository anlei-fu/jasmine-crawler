package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.service.EnableTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EnableDownSystemSiteJob {

    @Autowired
    private EnableTaskService enableTaskService;

    @Scheduled(cron = "0/50 * * * * ?")
    public void  run(){
        enableTaskService.enable();
    }
}
