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

    @Scheduled(cron = "0 */9 * * * ?")
    public void snapShot10Minute() {
        long tenMin = 1000 * 60 * 10;
        Date date = new Date(System.currentTimeMillis() / tenMin * tenMin);
        taskSnapShot10MinuteService.delete(date);
        taskSnapShot10MinuteService.snapShot10Minute(date);
    }
}
