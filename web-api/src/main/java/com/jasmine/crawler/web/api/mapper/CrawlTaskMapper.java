package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CrawlTaskMapper {
    CrawlTask getCrawlTaskForUpdate(@Param("id") Integer id);
}
