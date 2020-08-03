package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Site;

public interface SiteService {

    /**
     * Get site info
     *
     * @param siteId
     * @return
     */
    Site get(Integer siteId);
}
