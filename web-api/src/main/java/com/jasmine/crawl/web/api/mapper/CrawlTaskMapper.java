package com.jasmine.crawl.web.api.mapper;

import com.jasmine.crawl.common.pojo.entity.CrawlTask;
import org.mapstruct.Mapper;

@Mapper
public interface CrawlTaskMapper {
    CrawlTask getCrawlTaskForUpdateById(Integer taskId);
}
