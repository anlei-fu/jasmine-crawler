/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.BindRecordMapper;
import com.jasmine.crawler.cron.service.BindRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindRecordServiceImpl implements BindRecordService {

    @Autowired
    private BindRecordMapper bindRecordMapper;

    @Override
    public void add(Integer taskId, Integer bindStatus,String msg) {
          bindRecordMapper.add(taskId,bindStatus,msg);
    }
}

