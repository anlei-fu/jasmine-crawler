package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;

import java.util.List;

public interface DownSystemSiteService {
    /**
     * Get the sites which need to create new task determine by site.{@field maxWaitToBindTaskCount}
     *
     * @return
     */
    List<DownSystemSite> getNeedCreateNewTaskSites();

    /**
     * Get by id
     *
     * @param downSystemSiteId
     * @return
     */
    DownSystemSite get(Integer downSystemSiteId);

    /**
     * Increase current running task count
     *
     * @param downSystemSiteId
     */
    void increaseRunningTaskCount(Integer downSystemSiteId);

    /**
     * Decrease current running task count
     *
     * @param downSystemSiteId
     */
    void decreaseCurrentRunningTaskCount(Integer downSystemSiteId);

    /**
     * Increase current bind task count
     *
     * @param id
     */
    void increaseCurrentTaskCount(Integer id);

    /**
     * Decrease current bind task count
     *
     * @param downSystemId
     */
    void decreaseCurrentTaskCount(Integer downSystemId);

    /**
     * Get the sites which need to reset failed urls
     *
     * @return
     */
    List<DownSystemSite> getNeedExecuteFailedRetryJobSites();

    /**
     * Update url next failed retry job execute time
     *
     * @param id
     */
    void updateUrlNextFailedRetryJobExecuteTime(Integer id);

    /**
     * Get the sites which need to reset succeed urls
     *
     * @return
     */
    List<DownSystemSite> getNeedExecuteResetJobSites();

    /**
     * Update url next reset job execute time
     *
     * @param id
     */
    void updateUrlNextResetJobExecuteTime(Integer id);

    /**
     * Get the sites which need to reset cached timeout urls
     *
     * @return
     */
    List<DownSystemSite> getNeedExecuteUrlCacheTimeoutJobSites();

    /**
     * Reset cache timeout job next excute time
     *
     * @param id
     */
    void updateUrlNextCacheTimeoutJobExecuteTime(Integer id);
}
