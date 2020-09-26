package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.Crawler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrawlerMapper {
    void reduceCurrentConcurrency(@Param("id") Integer id, @Param("concurrencyToDecrease") Integer concurrencyToDecrease);

    Crawler get(@Param("id") Integer id);
}
