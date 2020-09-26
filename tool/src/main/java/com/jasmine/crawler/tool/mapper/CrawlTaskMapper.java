package com.jasmine.crawler.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrawlTaskMapper {
    int deleteTaskByDownSystemSite(@Param("downSystemSiteId") Integer downSystemSiteId);

    int deleteTaskByDownSystem(Integer downSystemId);
}
