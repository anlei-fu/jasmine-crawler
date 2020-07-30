package com.jasmine.crawler.web.api.mapper;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

@Mapper
public interface CrawlTaskMapper {
    CrawlTask getCrawlTaskForUpdateById(@Param("id") Integer id);
}
