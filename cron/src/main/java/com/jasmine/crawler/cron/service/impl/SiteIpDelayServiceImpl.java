package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.cron.mapper.SiteIpDelayMapMapper;
import com.jasmine.crawler.cron.service.SiteIpDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteIpDelayServiceImpl implements SiteIpDelayService {

    @Autowired
    private SiteIpDelayMapMapper siteIpDelayMapMapper;

    @Override
    public void add(SiteIpDelayMap siteIpDelayMap) {
        siteIpDelayMapMapper.add(siteIpDelayMap);
    }
}
