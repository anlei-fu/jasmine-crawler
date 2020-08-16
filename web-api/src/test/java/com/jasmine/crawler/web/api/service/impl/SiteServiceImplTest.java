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
 * SiteServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteServiceImplTest {

    @Autowired
    private SiteServiceImpl service;

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

}
