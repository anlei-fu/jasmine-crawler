package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.Crawler;
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
        Crawler crawler = service.getCrawlerForSite(1, 24, true);
        TestUtils.print(crawler, "crawler");
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
        TestUtils.print(service.get(1), "target");
    }

    /**
     * Method: getCrawlersNeedHeartbeat()
     */
    @Test
    public void testGetCrawlersNeedHeartbeat() throws Exception {
        List<Crawler> crawlers = service.getCrawlersNeedHeartbeat();
        TestUtils.print(crawlers, "crawlers to send heartbeat");
    }

    /**
     * Method: updateHeartbeatStatus(Integer crawlerId, Integer heartbeatStatus)
     */
    @Test
    public void testUpdateHeartbeatStatus() throws Exception {
        service.updateHeartbeatStatus(1, true);
    }

} 
