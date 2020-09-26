package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.cron.mapper.DownSystemMapper;
import com.jasmine.crawler.cron.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Override
    public DownSystem get(Integer downSystemId) {
        return downSystemMapper.getById(downSystemId);
    }

    @Override
    public void increaseRunningTaskCount(Integer id) {
        downSystemMapper.increaseTaskRunningCountById(id);
    }

    @Override
    public void decreaseCurrentRunningTaskCount(Integer id) {
        downSystemMapper.decreaseCurrentRunningTaskCountById(id);
    }
}
