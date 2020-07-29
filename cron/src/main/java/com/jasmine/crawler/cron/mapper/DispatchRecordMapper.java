package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawl.common.pojo.entity.DispatchRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchRecordMapper {
    void add(DispatchRecord record);
}
