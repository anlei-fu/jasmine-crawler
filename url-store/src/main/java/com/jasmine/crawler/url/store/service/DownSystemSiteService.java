package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemSiteService {
    DownSystemSite get(Integer id);

    void increaseNewUrlCount(Integer downSystemSiteId, int size);

    void increaseBadUrlCount(Integer id, int size);

    void increaseFinishedUrlCount(Integer id, int size);
}
