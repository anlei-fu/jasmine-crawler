package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;

public interface DownSystemSiteService {
    DownSystemSite getById(Integer downSiteId);

    void decreaseCurrentRunningTaskCount(Integer id);
}
