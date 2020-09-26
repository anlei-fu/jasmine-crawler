package com.jasmine.crawler.tool.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrawlerMapper {
    void resetConcurrency(@Param("id") Integer id);

    void resetHeartbeatLost(@Param("id") Integer id);
}

