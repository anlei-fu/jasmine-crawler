package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.Site;

public interface SiteService {
    Site getById(Integer siteId);

    void decreaseCurrentRunningTaskCount(Integer id);
}
