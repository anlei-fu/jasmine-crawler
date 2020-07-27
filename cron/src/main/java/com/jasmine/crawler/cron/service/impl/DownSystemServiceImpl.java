package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.DownSystemMapper;
import com.jasmine.crawler.cron.pojo.entity.DownSystem;
import com.jasmine.crawler.cron.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class DownSystemServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Override
    public DownSystem getById(Integer downSystemId) {
        return downSystemMapper.getById(downSystemId);
    }

    @Override
    public void increaseTaskRunningCountById(Integer id) {
        downSystemMapper.increaseTaskRunningCountById(id);
    }

    @Override
    public void decreaseCurrentRunningTaskCountById(Integer id) {
        downSystemMapper.decreaseCurrentRunningTaskCountById(id);
    }
}
