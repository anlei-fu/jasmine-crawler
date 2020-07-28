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
    List<DownSystemSite> getNeedCreateNewTaskSite();

    DownSystemSite getById(Integer downSiteId);

    void increaseTaskRunningCountById(Integer downSystemId);

    void decreaseCurrentRunningTaskCountById(Integer id);
}
