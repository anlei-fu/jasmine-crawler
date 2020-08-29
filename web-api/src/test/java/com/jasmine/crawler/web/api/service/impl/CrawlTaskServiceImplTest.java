package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

        List<PageResult> prs = new LinkedList<>();
        PageResult pr = PageResult.builder()
                .taskId(6987)
                .id(1)
                .pageResult(1)
                .data("")
                .httpStatus(200)
                .crawlTime(new Date())
                .newUrls(new LinkedList<>())
                .msg("ok")
                .build();
        prs.add(pr);

        SaveTaskResultReq taskResultReq = SaveTaskResultReq
                .builder()
                .taskId(6987)
                .msg("ok")
                .taskResult(1)
                .averageSpeedOfAll(1)
                .medianSpeedOfSuccess(1)
                .averageSpeedOfAll(1)
                .maxSpeedOfSuccess(1)
                .pageResults(prs)
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
