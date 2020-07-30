package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.Site;
import com.jasmine.crawler.cron.mapper.SiteMapper;
import com.jasmine.crawler.cron.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public Site get(Integer id) {
        return siteMapper.getById(id);
    }

    @Override
    public void increaseRunningTaskCount(Integer id) {
        siteMapper.increaseTaskRunningCountById(id);
    }

    @Override
    public void decreaseCurrentRunningTaskCountById(Integer id) {
        siteMapper.decreaseCurrentRunningTaskCountById(id);
    }
}
