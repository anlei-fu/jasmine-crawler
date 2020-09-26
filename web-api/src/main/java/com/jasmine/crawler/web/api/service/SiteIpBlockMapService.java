package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;

public interface SiteIpBlockMapService {

    /**
     * Add a block record
     *
     * @param siteIpBlockMap
     */
    void add(SiteIpBlockMap siteIpBlockMap);
}
