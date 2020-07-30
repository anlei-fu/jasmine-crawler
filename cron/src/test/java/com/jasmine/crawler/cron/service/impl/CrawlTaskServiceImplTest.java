package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.constant.BindStatus;
import com.jasmine.crawler.common.constant.DispatchStatus;
import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* CrawlTaskServiceImpl Tester. 
* 
* @author fuanlei 
* @since <pre>07/30/2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrawlTaskServiceImplTest { 

@Autowired
private  CrawlTaskServiceImpl  service;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getTasksToBind(Integer level) 
* 
*/ 
@Test
public void testGetTasksToBind() throws Exception { 

} 

/** 
* 
* Method: delete(Integer taskId) 
* 
*/ 
@Test
public void testDelete() throws Exception { 
  service.delete(1);
} 

/** 
* 
* Method: dispatchSuccess(Integer taskId) 
* 
*/ 
@Test
public void testDispatchSuccess() throws Exception { 
  service.dispatchSuccess(1);
} 

/** 
* 
* Method: add(CrawlTask taskToCreate) 
* 
*/ 
@Test
public void testAdd() throws Exception {
    CrawlTask task = CrawlTask.builder()
            .downSystemSiteId(1)
            .siteId(1)
            .build();
    service.add(task);
} 

/** 
* 
* Method: getTasksConfigsToDispatch() 
* 
*/ 
@Test
public void testGetTasksConfigsToDispatch() throws Exception { 

} 

/** 
* 
* Method: getTimeoutTasksToTerminate() 
* 
*/ 
@Test
public void testGetTimeoutTasksToTerminate() throws Exception { 
service.getTimeoutTasksToTerminate();
} 

/** 
* 
* Method: bindFailed(CrawlTask taskToUpdate) 
* 
*/ 
@Test
public void testBindFailed() throws Exception {
    CrawlTask task = CrawlTask.builder()
            .id(1)
            .lastBindStatus(BindStatus.DOWN_SYSTEM_NOT_AVAILABLE)
            .lastBindMsg("s")
            .build();
   service.bindFailed(task);
} 

/** 
* 
* Method: bindSuccess(CrawlTask crawlTaskToUpdate) 
* 
*/ 
@Test
public void testBindSuccess() throws Exception { 
  service.bindSuccess(1);
} 

/** 
* 
* Method: terminateTimeoutTask(Integer id, Integer timeout) 
* 
*/ 
@Test
public void testTerminateTimeoutTask() throws Exception {
   service.terminateTimeoutTask(1);
} 

/** 
* 
* Method: dispatchFailed(CrawlTask dispatchFailedTask) 
* 
*/ 
@Test
public void testDispatchFailed() throws Exception {
    CrawlTask task = CrawlTask.builder()
            .id(1)
            .dispatchStatus(DispatchStatus.COOKIE_NOT_AVAILABLE)
            .dispatchMsg("s")
            .build();
    service.dispatchFailed(task);
} 


} 