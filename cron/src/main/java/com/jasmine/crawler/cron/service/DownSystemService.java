package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DownSystem;

public interface DownSystemService {
    /**
     * Get down system info
     *
     * @param downSystemId
     * @return
     */
    DownSystem get(Integer downSystemId);

    /**
     * Increase current running task count
     *
     * @param downSystemId
     */
    void increaseRunningTaskCount(Integer downSystemId);

    /**
     * Decrease current running task count
     *
     * @param downSystemId
     */
    void decreaseCurrentRunningTaskCount(Integer downSystemId);
}
