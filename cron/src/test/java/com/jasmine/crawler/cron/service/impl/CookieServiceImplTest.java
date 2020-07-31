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
 * CookieServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CookieServiceImplTest {

    @Autowired
    private CookieServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(Integer id)
     */
    @Test
    public void testGet() throws Exception {
        service.get(1);
    }

    /**
     * Method: getCookieForSite(Integer siteId)
     */
    @Test
    public void testGetCookieForSite() throws Exception {
        service.getCookieForSite(1);
    }

    /**
     * Method: increaseCurrentUseCount(Integer id)
     */
    @Test
    public void testIncreaseCurrentUseCount() throws Exception {
        service.increaseCurrentUseCount(1);
    }

    /**
     * Method: getExpiredCookies()
     */
    @Test
    public void testRemoveExpiredCookies() throws Exception {
        service.removeExpiredCookies();
    }

    /**
     * Method: decreaseCurrentUseCount(Integer id)
     */
    @Test
    public void testDecreaseCurrentUseCount() throws Exception {
        service.increaseCurrentUseCount(1);
    }

} 
