package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;

import java.util.List;

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

    /**
     * Get down system sites which need execute url cache timeout job
     *
     * @return
     */
    List<DownSystemSite> getUrlCacheTimeoutJobSites();

    /**
     * Update last executing url cache timeout job time
     *
     * @param id
     */
    void updateUrlLastCacheTimeoutJobTime(Integer id);
}
