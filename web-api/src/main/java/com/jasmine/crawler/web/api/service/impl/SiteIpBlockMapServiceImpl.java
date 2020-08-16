package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import com.jasmine.crawler.web.api.mapper.SiteIpBlockMapMapper;
import com.jasmine.crawler.web.api.service.SiteIpBlockMapService;
import org.springframework.beans.factory.annotation.Autowired;

public class SiteIpBlockMapServiceImpl implements SiteIpBlockMapService {

    @Autowired
    private SiteIpBlockMapMapper siteIpBlockMapMapper;

    @Override
    public void add(SiteIpBlockMap siteIpBlockMap) {
        siteIpBlockMapMapper.add(siteIpBlockMap);
    }
}
