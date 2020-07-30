package com.jasmine.crawler.cron.mapper;

import com.jasmine.crawler.common.pojo.entity.DispatchRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DispatchRecordMapper {
    void add(DispatchRecord record);
}
