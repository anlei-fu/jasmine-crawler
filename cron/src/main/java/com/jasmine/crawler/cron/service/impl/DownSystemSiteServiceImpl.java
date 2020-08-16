package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.cron.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        downSystemSiteMapper.increaseCurrentRunningTaskCount(downSystemSiteId);
    }

    @Override
    public void decreaseCurrentRunningTaskCount(Integer downSystemSiteId) {
        downSystemSiteMapper.decreaseCurrentRunningTaskCount(downSystemSiteId);
    }

    @Override
    public void increaseCurrentTaskCount(Integer id) {
        downSystemSiteMapper.increaseCurrentTaskCount(id);
    }

    @Override
    public void decreaseCurrentTaskCount(Integer downSystemId) {
        downSystemSiteMapper.decreaseCurrentTaskCount(downSystemId);
    }
}
