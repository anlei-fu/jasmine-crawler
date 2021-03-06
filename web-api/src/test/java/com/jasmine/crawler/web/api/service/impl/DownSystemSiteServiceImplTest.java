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
 * DownSystemSiteServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
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
     * Method: decreaseCurrentRunningTaskCount(Integer id)
     */
    @Test
    public void testDecreaseCurrentRunningTaskCount() throws Exception {
        service.decreaseCurrentRunningTaskCount(1);
    }

} 
