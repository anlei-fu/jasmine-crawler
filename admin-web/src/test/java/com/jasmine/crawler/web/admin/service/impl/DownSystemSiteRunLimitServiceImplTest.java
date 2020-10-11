package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.web.admin.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DownSystemSiteRunLimitServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>09/26/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemSiteRunLimitServiceImplTest {

    @Autowired
    private DownSystemSiteRunLimitServiceImpl service;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getByDownSystemSiteId(Integer downSystemSiteId)
     */
    @Test
    public void testGetByDownSystemSiteId() throws Exception {

    }

    /**
     * Method: disable(Integer id)
     */
    @Test
    public void testDisable() throws Exception {

    }

    /**
     * Method: enable(Integer id)
     */
    @Test
    public void testEnable() throws Exception {

    }

    /**
     * Method: createLimit(int id)
     */
    @Test
    public void testCreateLimit() throws Exception {
        service.createLimit(49);
    }

    /**
     * Method: update(UpdateDownSystemRunLimitReq req)
     */
    @Test
    public void testUpdate() throws Exception {

    }


} 
