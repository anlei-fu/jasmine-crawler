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
 * CrawlerServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrawlerServiceImplTest {

    @Autowired
    private CrawlerServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getCrawlerForSite(Integer siteId)
     */
    @Test
    public void testGetCrawlerForSite() throws Exception {
//        service.getCrawlerForSite(site.getId(), 24, true);
    }

    /**
     * Method: increaseCurrentConcurrency(Integer id, Integer concurrencyToIncrease)
     */
    @Test
    public void testIncreaseCurrentConcurrency() throws Exception {
        service.changeCurrentConcurrency(1, 100);
    }

    /**
     * Method: get(int crawlerId)
     */
    @Test
    public void testGet() throws Exception {
        service.get(1);
    }

    /**
     * Method: getCrawlersNeedHeartbeat()
     */
    @Test
    public void testGetCrawlersNeedHeartbeat() throws Exception {
        service.getCrawlersNeedHeartbeat();
    }

    /**
     * Method: updateHeartbeatStatus(Integer crawlerId, Integer heartbeatStatus)
     */
    @Test
    public void testUpdateHeartbeatStatus() throws Exception {
        service.updateHeartbeatStatus(1, 0);
    }

} 
