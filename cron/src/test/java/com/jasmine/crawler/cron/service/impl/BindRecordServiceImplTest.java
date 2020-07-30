package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.constant.BindStatus;
import com.jasmine.crawler.common.pojo.entity.BindRecord;
import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* BindRecordServiceImpl Tester. 
* 
* @author fuanlei 
* @since <pre>07/30/2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BindRecordServiceImplTest { 

@Autowired
private  BindRecordServiceImpl  service;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(BindRecord record) 
* 
*/ 
@Test
public void testAdd() throws Exception {
    BindRecord record = BindRecord
            .builder()
            .bindStatus(BindStatus.DOWN_SYSTEM_NOT_AVAILABLE)
            .crawlTaskId(1)
            .bindMsg("failed")
            .build();
   service.add(record);
} 


} 
