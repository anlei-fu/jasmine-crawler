package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;

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
}
