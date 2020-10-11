package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.Application;
import com.jasmine.crawler.cron.service.DownSystemSiteService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UrlServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>10/11/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UrlServiceImplTest {

    @Autowired
    private UrlServiceImpl service;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUrlToExecuteForSite(Integer downSystemSiteId, Integer taskUrlBatchCount)
     */
    @Test
    public void testGetUrlToExecuteForSite() throws Exception {

    }

    /**
     * Method: resetCachedUrlToWaitByDownSystemSite(DownSystemSite downSystemSiteId)
     */
    @Test
    public void testResetCachedUrlToWaitByDownSystemSite() throws Exception {
        service.resetCachedUrlToWaitByDownSystemSite(downSystemSiteService.get(51));
    }

    /**
     * Method: resetFailedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite)
     */
    @Test
    public void testResetFailedUrlToWaitByDownSystemSite() throws Exception {
              service.resetFailedUrlToWaitByDownSystemSite(downSystemSiteService.get(54));
    }

    /**
     * Method: resetSuccessUrlToWaitByDownSystemSite(DownSystemSite downSystemSite)
     */
    @Test
    public void testResetSuccessUrlToWaitByDownSystemSite() throws Exception {
        service.resetSuccessUrlToWaitByDownSystemSite(downSystemSiteService.get(54));
    }


} 
