package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.url.store.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.url.store.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemSiteServiceImpl implements DownSystemSiteService {

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Override
    public DownSystemSite get(Integer downSystemId) {
        return downSystemSiteMapper.get(downSystemId);
    }

    @Override
    public void addNewUrlCount(Integer downSystemSiteId, int size) {
        downSystemSiteMapper.addNewUrlCount(downSystemSiteId, size);
    }

    @Override
    public void addBadUrlCount(Integer id, int size) {
        downSystemSiteMapper.addBadUrlCount(id, size);
    }

    @Override
    public void addFinishedUrlCount(Integer id, int size) {
        downSystemSiteMapper.addFinishedUrlCount(id, size);
    }
}
