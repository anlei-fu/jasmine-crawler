package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.cron.pojo.entity.DownSystem;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemService {
    DownSystem getById(Integer downSystemId);

    void increaseTaskRunningCountById(Integer downSystemId);

    void decreaseCurrentRunningTaskCountById(Integer id);
}
