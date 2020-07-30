package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;

public interface DownSystemSiteService {

    /**
     * Get down system site info
     *
     * @param downSystemSiteId
     * @return
     */
    DownSystemSite get(Integer downSystemSiteId);

    /**
     * Decrease current running task count
     *
     * @param downSystemSiteId
     */
    void decreaseCurrentRunningTaskCount(Integer downSystemSiteId);
}
