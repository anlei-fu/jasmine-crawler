package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* DownSystemServiceImpl Tester. 
* 
* @author fuanlei 
* @since <pre>07/30/2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemServiceImplTest { 

@Autowired
private  DownSystemServiceImpl  service;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: get(Integer downSystemId) 
* 
*/ 
@Test
public void testGet() throws Exception { 
  service.get(1);
} 

/** 
* 
* Method: increaseRunningTaskCount(Integer id) 
* 
*/ 
@Test
public void testIncreaseRunningTaskCount() throws Exception { 
  service.increaseRunningTaskCount(1);
} 

/** 
* 
* Method: decreaseCurrentRunningTaskCount(Integer id) 
* 
*/ 
@Test
public void testDecreaseCurrentRunningTaskCount() throws Exception { 
 service.decreaseCurrentRunningTaskCount(1);
} 


} 
