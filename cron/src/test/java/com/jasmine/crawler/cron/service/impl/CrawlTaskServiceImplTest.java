package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.constant.BindResult;
import com.jasmine.crawler.common.constant.DispatchResult;
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
 * @version 1.0
 * @since <pre>07/30/2020</pre>
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
     * Method: getTasksToBind(Integer level)
     */
    @Test
    public void testGetTasksToBind() throws Exception {
        service.getTasksToBind(1);
    }

    /**
     * Method: delete(Integer taskId)
     */
    @Test
    public void testDelete() throws Exception {
        service.delete(1);
    }

    /**
     * Method: dispatchSuccess(Integer taskId)
     */
    @Test
    public void testDispatchSuccess() throws Exception {
       // service.dispatchSuccess(crawlTaskConfig.getTaskId(), 1);
    }

    /**
     * Method: add(CrawlTask taskToCreate)
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
     * Method: getTasksConfigsToDispatch()
     */
    @Test
    public void testGetTasksConfigsToDispatch() throws Exception {
        service.getTasksConfigsToDispatch();
    }

    /**
     * Method: getTimeoutTasksToTerminate()
     */
    @Test
    public void testGetTimeoutTasksToTerminate() throws Exception {
        service.getTimeoutTasksToTerminate();
    }

    /**
     * Method: bindFailed(CrawlTask taskToUpdate)
     */
    @Test
    public void testBindFailed() throws Exception {
        CrawlTask task = CrawlTask.builder()
                .id(1)
                .bindLastResult(BindResult.DOWN_SYSTEM_NOT_AVAILABLE)
                .bindLastMsg("s")
                .build();
        service.bindFailed(task);
    }

    /**
     * Method: bindSuccess(CrawlTask crawlTaskToUpdate)
     */
    @Test
    public void testBindSuccess() throws Exception {
        service.bindSuccess(null);
    }

    /**
     * Method: terminateTimeoutTask(Integer id, Integer timeout)
     */
    @Test
    public void testTerminateTimeoutTask() throws Exception {
        service.terminateExecuteTimeoutTask(1);
    }

    /**
     * Method: dispatchFailed(CrawlTask dispatchFailedTask)
     */
    @Test
    public void testDispatchFailed() throws Exception {
        CrawlTask task = CrawlTask.builder()
                .id(1)
                .dispatchLastResult(DispatchResult.COOKIE_NOT_AVAILABLE)
                .dispatchLastMsg("s")
                .build();
        service.dispatchFailed(task);
    }

} 
