package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemSiteService {
    DownSystemSite getById(Integer downSiteId);

    void decreaseCurrentRunningTaskCount(Integer id);
}
