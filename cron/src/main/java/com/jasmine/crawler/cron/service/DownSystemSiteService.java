package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemSiteService {
    /**
     * Get sites which need to create new task
     *
     * @return
     */
    List<DownSystemSite> getNeedCreateNewTaskSite();

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
    void increaseTaskRunningCount(Integer downSystemSiteId);

    /**
     * Decrease current running task count
     *
     * @param downSystemSiteId
     */
    void decreaseCurrentRunningTaskCountById(Integer downSystemSiteId);
}
