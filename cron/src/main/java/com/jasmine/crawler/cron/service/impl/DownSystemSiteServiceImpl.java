package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawl.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.cron.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class DownSystemSiteServiceImpl implements DownSystemSiteService {

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Override
    public List<DownSystemSite> getNeedCreateNewTaskSites() {
        return downSystemSiteMapper.getNeedCreateNewTaskSite();
    }

    @Override
    public DownSystemSite get(Integer downSystemSiteId) {
        return downSystemSiteMapper.getById(downSystemSiteId);
    }

    @Override
    public void increaseRunningTaskCount(Integer downSystemSiteId) {
        downSystemSiteMapper.increaseRunningTaskCountById(downSystemSiteId);
    }

    @Override
    public void decreaseCurrentRunningTaskCount(Integer downSystemSiteId) {
        downSystemSiteMapper.decreaseCurrentRunningTaskCountById(downSystemSiteId);
    }
}
