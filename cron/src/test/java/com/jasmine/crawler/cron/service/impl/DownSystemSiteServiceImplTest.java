package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.util.TestUtils;
import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * DownSystemSiteServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemSiteServiceImplTest {

    @Autowired
    private DownSystemSiteServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getNeedCreateNewTaskSites()
     */
    @Test
    public void testGetNeedCreateNewTaskSites() throws Exception {
        List<DownSystemSite> sites = service.getNeedCreateNewTaskSites();
        TestUtils.print(sites, "sites to create task");
    }

    /**
     * Method: get(Integer downSystemSiteId)
     */
    @Test
    public void testGet() throws Exception {
        service.get(1);
    }

    /**
     * Method: increaseRunningTaskCount(Integer downSystemSiteId)
     */
    @Test
    public void testIncreaseRunningTaskCount() throws Exception {
        service.increaseRunningTaskCount(1);
    }

    /**
     * Method: decreaseCurrentRunningTaskCount(Integer downSystemSiteId)
     */
    @Test
    public void testDecreaseCurrentRunningTaskCount() throws Exception {
        service.decreaseCurrentRunningTaskCount(1);
    }

    @Test
    public void testIncreaseCurrentBindCount() {
        service.increaseCurrentTaskCount(1);
    }

    @Test
    public void testDecreaseCurrentBindCount() {
        service.decreaseCurrentTaskCount(1);
    }

    @Test
    public void testGetUrlCacheTimeoutJobSites() {
        service.getNeedExecuteUrlCacheTimeoutJobSites();
    }

    @Test
    public void testUpdateUrlNextCacheTimeoutJobTime() {
        service.updateUrlNextCacheTimeoutJobExecuteTime(54);
    }

    @Test
    public void testGetNeedExecuteFailedRetryJobSites() {
        service.getNeedExecuteFailedRetryJobSites();
    }

    @Test
    public void testUpdateUrlNextFailedRetryJobTime() {
        service.updateUrlNextFailedRetryJobExecuteTime(54);
    }

    @Test
    public void testGetNeedExecuteResetJobSites() {
        service.getNeedExecuteResetJobSites();
    }

    @Test
    public void testUpdateUrlNextResetJobTime() {
        service.updateUrlNextResetJobExecuteTime(54);
    }
} 
