package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.SiteMapper;
import com.jasmine.crawl.common.pojo.entity.Site;
import com.jasmine.crawler.cron.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public Site getById(Integer id) {
        return siteMapper.getById(id);
    }

    @Override
    public void increaseTaskRunningCountById(Integer id) {
          siteMapper.increaseTaskRunningCountById(id);
    }

    @Override
    public void decreaseCurrentRunningTaskCountById(Integer id) {
        siteMapper.decreaseCurrentRunningTaskCountById(id);
    }
}
