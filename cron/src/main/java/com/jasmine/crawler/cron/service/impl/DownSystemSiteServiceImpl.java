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
        return downSystemSiteMapper.getNeedCreateNewTaskSites();
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

    @Override
    public List<DownSystemSite> getNeedExecuteFailedRetryJobSites() {
        return downSystemSiteMapper.getNeedExecuteFailedRetryJobSites();
    }

    @Override
    public void updateUrlNextFailedRetryJobExecuteTime(Integer id) {
        downSystemSiteMapper.updateUrlNextFailedRetryJobTime(id);
    }

    @Override
    public List<DownSystemSite> getNeedExecuteResetJobSites() {
        return downSystemSiteMapper.getNeedExecuteResetJobSites();
    }

    @Override
    public void updateUrlNextResetJobExecuteTime(Integer id) {
        downSystemSiteMapper.updateUrlNextResetJobTime(id);
    }

    @Override
    public List<DownSystemSite> getNeedExecuteUrlCacheTimeoutJobSites() {
        return downSystemSiteMapper.getUrlCacheTimeoutJobSites();
    }

    @Override
    public void updateUrlNextCacheTimeoutJobExecuteTime(Integer id) {
        downSystemSiteMapper.updateUrlNextCacheTimeoutJobTime(id);
    }


}
