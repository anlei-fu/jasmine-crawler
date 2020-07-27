package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.DispatchRecordMapper;
import com.jasmine.crawler.cron.service.DispatchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class DispatchRecordServiceImpl implements DispatchRecordService {

    @Autowired
    private DispatchRecordMapper dispatchRecordMapper;

    @Override
    public void addRecord(Integer taskId, Integer dispatchStatus, String msg) {
          dispatchRecordMapper.add(taskId,dispatchStatus,msg);
    }
}
