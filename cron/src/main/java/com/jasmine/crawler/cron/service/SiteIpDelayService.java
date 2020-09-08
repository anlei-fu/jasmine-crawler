package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;

public interface SiteIpDelayService {
    /**
     * Add site ip delay mapping
     *
     * @param siteIpDelayMap
     */
    void add(SiteIpDelayMap siteIpDelayMap);
}
