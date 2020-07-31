package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface CrawlerMapper {
    void decreaseCurrentConcurrency(@Param("id") Integer id, @Param("concurrencyToDecrease") Integer concurrencyToDecrease);

    Crawler get(@Param("id") Integer id);

    void finishTask(CrawlTask crawlTaskToUpdate);
}
