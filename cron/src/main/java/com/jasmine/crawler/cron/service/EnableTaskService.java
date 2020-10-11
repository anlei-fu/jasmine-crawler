package com.jasmine.crawler.cron.service;

public interface EnableTaskService {
    void scheduleNextEnable(Integer downSystemSiteId, int delayMinutes);

    void enable();
}
