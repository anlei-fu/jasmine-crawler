package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.Site;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface SiteService {
    Site getById(Integer siteId);

    void decreaseCurrentRunningTaskCount(Integer id);
}
