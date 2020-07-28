package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.DownSystem;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
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
    void increaseTaskRunningCount(Integer downSystemId);

    /**
     * Decrease current running task count
     *
     * @param downSystemId
     */
    void decreaseCurrentRunningTaskCount(Integer downSystemId);
}
