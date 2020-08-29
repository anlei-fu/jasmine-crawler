package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.util.TestUtils;
import com.jasmine.crawler.cron.Application;
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
 * @since <pre>07/30/2020</pre>
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
     * Method: getProxyForSite(Integer siteId)
     */
    @Test
    public void testGetProxyForSite() throws Exception {
        Proxy p = service.getProxyForSite(1);
        TestUtils.print(p, "proxy");
    }

    /**
     * Method: increaseCurrentUseCount(Integer proxyId)
     */
    @Test
    public void testIncreaseCurrentUseCount() throws Exception {
        service.increaseCurrentUseCount(1);
    }

    /**
     * Method: get(Integer id)
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

} 
