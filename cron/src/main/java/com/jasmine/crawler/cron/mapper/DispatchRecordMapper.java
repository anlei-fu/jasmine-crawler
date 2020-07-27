package com.jasmine.crawler.cron.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Mapper
public interface DispatchRecordMapper {
    void add(Integer taskId, Integer dispatchStatus, String msg);
}
