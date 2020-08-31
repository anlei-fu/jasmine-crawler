package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.web.api.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.web.api.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemSiteServiceImpl implements DownSystemSiteService {

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Override
    public DownSystemSite get(Integer downSystemSiteId) {
        return downSystemSiteMapper.get(downSystemSiteId);
    }

    @Override
    public void decreaseCurrentRunningTaskCount(Integer id) {
        downSystemSiteMapper.decreaseCurrentRunningTaskCount(id);
    }

}
