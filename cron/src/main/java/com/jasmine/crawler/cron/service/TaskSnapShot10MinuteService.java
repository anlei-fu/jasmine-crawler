package com.jasmine.crawler.cron.service;

import java.util.Date;

public interface TaskSnapShot10MinuteService {

    /**
     * Make task 10 minute snapshot at time
     *
     * @param time
     */
    void snapShot10Minute(Date time);

    /**
     * Delete existed task 10 minute snapshot
     *
     * @param date
     */
    void delete(Date date);
}
