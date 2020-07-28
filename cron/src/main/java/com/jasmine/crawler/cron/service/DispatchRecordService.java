package com.jasmine.crawler.cron.service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DispatchRecordService {
    void addRecord(Integer taskId, Integer dispatchStatus, String msg);
}
