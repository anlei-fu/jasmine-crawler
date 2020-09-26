package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.service.TaskSnapShot10MinuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskSnapShotJob {

    @Autowired
    private TaskSnapShot10MinuteService taskSnapShot10MinuteService;


    @Scheduled(cron = "0 */10 * * * *")
    public void snapShot10Minute() {
        Date date = new Date(System.currentTimeMillis() % (1000 * 60 * 10));
        taskSnapShot10MinuteService.delete(date);
        taskSnapShot10MinuteService.snapShot10Minute(date);
    }
}
