package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SiteIpBlockMapMapper {
    void add(SiteIpBlockMap siteIpBlockMap);
}
