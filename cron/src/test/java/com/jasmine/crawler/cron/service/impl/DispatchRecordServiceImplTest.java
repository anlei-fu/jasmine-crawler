package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.constant.DispatchResult;
import com.jasmine.crawler.common.pojo.entity.DispatchRecord;
import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DispatchRecordServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DispatchRecordServiceImplTest {

    @Autowired
    private DispatchRecordServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(DispatchRecord record)
     */
    @Test
    public void testAdd() throws Exception {
        DispatchRecord record = DispatchRecord.builder()
                .crawlTaskId(1)
                .dispatchMsg("sss")
                .dispatchResult(DispatchResult.COOKIE_NOT_AVAILABLE)
                .build();
    }

} 
