package com.jasmine.crawler.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UrlMapper {
    int resetSeedUrlStatus(@Param("downSystemSiteId") Integer downSystemSiteId);

    int resetUrlStatus(@Param("downSystemSiteId") Integer downSystemSiteId);

    int resetCachedUrlStatus(@Param("downSystemSiteId") Integer downSystemSiteId);
}
