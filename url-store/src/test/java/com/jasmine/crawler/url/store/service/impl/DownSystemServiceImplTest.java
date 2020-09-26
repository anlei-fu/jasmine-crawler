package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DownSystemServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/31/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemServiceImplTest {

    @Autowired
    private DownSystemServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: increaseNewUrlCount(Integer downSystemId, int size)
     */
    @Test
    public void testIncreaseNewUrlCount() throws Exception {
        service.addNewUrlCount(1, 1);
    }

    /**
     * Method: increaseBadUrlCount(Integer downSystemId, int size)
     */
    @Test
    public void testIncreaseBadUrlCount() throws Exception {
        service.addBadUrlCount(1, 1);
    }

    /**
     * Method: increaseFinishedUrlCount(Integer downSystemId, int size)
     */
    @Test
    public void testIncreaseFinishedUrlCount() throws Exception {
        service.addFinishedUrlCount(1, 1);
    }

} 
