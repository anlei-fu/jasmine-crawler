package com.jasmine.crawler.web.api.service.impl;

import com.google.common.collect.Lists;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.Application;
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
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrawlTaskServiceImplTest {

    @Autowired
    private CrawlTaskServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: saveTaskResult(TaskResultReq req)
     */
    @Test
    public void testSaveTaskResult() throws Exception {
        SaveTaskResultReq taskResultReq = SaveTaskResultReq
                .builder()
                .taskId(1)
                .taskResult(1)
                .averageSpeedOfAll(1)
                .badUrls(Lists.newArrayList())
                .succeedUrls(Lists.newArrayList())
                .failedUrls(Lists.newArrayList())
                .newUrls(Lists.newArrayList())
                .data(Lists.newArrayList())
                .maxSpeedOfSuccess(1)
                .averageSpeedOfSuccess(1)
                .meanSpeedOfSuccess(1)
                .unCrawledUrls(Lists.newArrayList())
                .build();

        service.saveTaskResult(taskResultReq);
    }

    /**
     * Method: saveUrls(TaskResultReq req)
     */
    @Test
    public void testSaveUrls() throws Exception {

/* 
try { 
   Method method = CrawlTaskServiceImpl.getClass().getMethod("saveUrls", TaskResultReq.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: saveData(TaskResultReq req)
     */
    @Test
    public void testSaveData() throws Exception {

/* 
try { 
   Method method = CrawlTaskServiceImpl.getClass().getMethod("saveData", TaskResultReq.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: finishCrawTask(TaskResultReq req)
     */
    @Test
    public void testFinishCrawTask() throws Exception {

/* 
try { 
   Method method = CrawlTaskServiceImpl.getClass().getMethod("finishCrawTask", TaskResultReq.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: finishCrawlTask(TaskResultReq req)
     */
    @Test
    public void testFinishCrawlTask() throws Exception {

/* 
try { 
   Method method = CrawlTaskServiceImpl.getClass().getMethod("finishCrawlTask", TaskResultReq.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
