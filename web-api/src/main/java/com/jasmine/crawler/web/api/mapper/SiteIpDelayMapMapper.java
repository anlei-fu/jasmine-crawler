package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SiteIpDelayMapMapper {
    void add(SiteIpDelayMap siteIpDelayMap);
}
