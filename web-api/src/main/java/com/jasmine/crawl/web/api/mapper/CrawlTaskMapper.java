package com.jasmine.crawl.web.api.mapper;

import com.jasmine.crawl.common.pojo.entity.CrawlTask;
import org.mapstruct.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface CrawlTaskMapper {
    CrawlTask getCrawlTaskForUpdateById(Integer taskId);
}
