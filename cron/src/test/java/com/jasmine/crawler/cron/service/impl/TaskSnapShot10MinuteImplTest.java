package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * TaskSnapShot10MinuteImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>09/26/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TaskSnapShot10MinuteImplTest {

    @Autowired
    private TaskSnapShot10MinuteImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: snapShot10Minute(Date time)
     */
    @Test
    public void testSnapShot10Minute() throws Exception {
        Date date = new Date(System.currentTimeMillis() % (1000 * 60 * 10));
        service.snapShot10Minute(date);
    }

    /**
     * Method: delete(Date time)
     */
    @Test
    public void testDelete() throws Exception {
        Date date = new Date(System.currentTimeMillis() % (1000 * 60 * 10));
        service.delete(date);
    }


} 
