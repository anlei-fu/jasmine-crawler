package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.web.api.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProxyServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProxyServiceImplTest {

    @Autowired
    private ProxyServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: get(Integer proxyId)
     */
    @Test
    public void testGet() throws Exception {
        service.get(1);
    }

    /**
     * Method: decreaseCurrentUseCount(Integer id)
     */
    @Test
    public void testDecreaseCurrentUseCount() throws Exception {
        service.decreaseCurrentUseCount(1);
    }

    /**
     * Method: increaseBlockCount(Integer id)
     */
    @Test
    public void testIncreaseBlockCount() throws Exception {
        service.increaseBlockCount(1);
    }

    /**
     * Method: resetBlockCount(Integer id)
     */
    @Test
    public void testResetBlockCount() throws Exception {
        service.resetBlockCount(1);
    }

} 
