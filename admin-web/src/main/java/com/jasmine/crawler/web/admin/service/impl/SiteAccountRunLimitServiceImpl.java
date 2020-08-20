package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteAccountRunLimit;
import com.jasmine.crawler.web.admin.mapper.SiteAccountRunLimitMapper;
import com.jasmine.crawler.web.admin.service.SiteAccountRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteAccountRunLimitServiceImpl implements SiteAccountRunLimitService {

    @Autowired
    private SiteAccountRunLimitMapper siteAccountRunLimitMapper;

    @Override
    public List<SiteAccountRunLimit> getByDownSystemSiteId(Integer downSystemSiteId) {
        return siteAccountRunLimitMapper.getByDownSystemSiteId(downSystemSiteId);
    }

    @Override
    public boolean disable(Integer id) {
        return siteAccountRunLimitMapper.disable(id)>0;
    }

    @Override
    public boolean enable(Integer id) {
        return siteAccountRunLimitMapper.enable(id)>0;
    }
}
