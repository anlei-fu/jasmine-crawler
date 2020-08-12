package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.DispatchRecord;

public interface DispatchRecordService {

    /**
     * Add a task dispatch record
     *
     * @param record
     */
    void add(DispatchRecord record);
}
