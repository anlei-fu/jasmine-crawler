package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.url.store.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.url.store.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DownSystemSite get(Integer downSystemId) {
        return downSystemSiteMapper.get(downSystemId);
    }

    @Override
    public void increaseNewUrlCount(Integer downSystemSiteId, int size) {
        downSystemSiteMapper.increaseNewUrlCount(downSystemSiteId, size);
    }

    @Override
    public void increaseBadUrlCount(Integer id, int size) {
        downSystemSiteMapper.increaseBadUrlCount(id, size);
    }

    @Override
    public void increaseFinishedUrlCount(Integer id, int size) {
        downSystemSiteMapper.increaseFinishedUrlCount(id, size);
    }
}
