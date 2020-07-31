package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

/**
 * SiteAccountServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>07/30/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteAccountServiceImplTest {

    @Autowired
    private SiteAccountServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getBlockedAccount()
     */
    @Test
    public void testGetBlockedAccount() throws Exception {

    }

    /**
     * Method: changeEnableStatusBatch(List<Integer> ids, Integer status)
     */
    @Test
    public void testChangeEnableStatusBatch() throws Exception {

    }

    /**
     * Method: getAccountsToEnable()
     */
    @Test
    public void testGetAccountsToEnable() throws Exception {

    }

    /**
     * Method: increaseCurrentUseCount(Integer accountId)
     */
    @Test
    public void testIncreaseCurrentUseCount() throws Exception {
        service.increaseCurrentUseCount(1);
    }

    /**
     * Method: decreaseCurrentUseCount(Integer accountId)
     */
    @Test
    public void testDecreaseCurrentUseCount() throws Exception {
        service.decreaseCurrentUseCount(1);
    }

} 
