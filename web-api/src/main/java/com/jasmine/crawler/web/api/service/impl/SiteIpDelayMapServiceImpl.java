package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.web.api.mapper.SiteIpDelayMapMapper;
import com.jasmine.crawler.web.api.service.SiteIpDelayMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteIpDelayMapServiceImpl implements SiteIpDelayMapService {

    @Autowired
    private SiteIpDelayMapMapper siteIpDelayMapMapper;

    @Override
    public void add(SiteIpDelayMap siteIpDelayMap) {
        siteIpDelayMapMapper.add(siteIpDelayMap);
    }
}
