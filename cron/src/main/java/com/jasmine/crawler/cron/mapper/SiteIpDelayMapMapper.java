package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import org.mapstruct.Mapper;

@Mapper
public interface SiteIpDelayMapMapper {
    void add(SiteIpDelayMap siteIpDelayMap);
}
