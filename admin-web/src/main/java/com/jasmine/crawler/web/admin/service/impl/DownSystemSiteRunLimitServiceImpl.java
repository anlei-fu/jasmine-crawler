package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.web.admin.mapper.DownSystemSiteRunLimitMapper;
import com.jasmine.crawler.web.admin.service.DownSystemSiteRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DownSystemSiteRunLimitServiceImpl implements DownSystemSiteRunLimitService {

    @Autowired
    private DownSystemSiteRunLimitMapper downSystemSiteRunLimitMapper;

    @Override
    public List<DownSystemSiteRunLimit> getByDownSystemSiteId(Integer downSystemSiteId) {
        return downSystemSiteRunLimitMapper.getByDownSystemSiteId(downSystemSiteId);
    }

    @Override
    public boolean disable(Integer id) {
        return downSystemSiteRunLimitMapper.disable(id)>0;
    }

    @Override
    public boolean enable(Integer id) {
        return downSystemSiteRunLimitMapper.enable(id)>0;
    }
}
