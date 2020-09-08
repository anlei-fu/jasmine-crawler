package com.jasmine.crawler.web.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlMapper {
    Integer resetUrls(@Param("list") List<Integer> ids);

    Integer resetSeedUrl(@Param("downSystemSiteId") Integer downSystemSiteId);
}
