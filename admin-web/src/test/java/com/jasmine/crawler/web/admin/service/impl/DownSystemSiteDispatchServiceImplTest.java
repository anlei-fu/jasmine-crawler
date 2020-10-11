package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.web.admin.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DownSystemSiteDispatchServiceImpl Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since <pre>09/29/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemSiteDispatchServiceImplTest {

    @Autowired
    private DownSystemSiteDispatchServiceImpl service;

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
          service.getBySourceDownSystemSiteId(1);
    }

    /**
     * Method: add(DownSystemSiteDispatch req)
     */
    @Test
    public void testAdd() throws Exception {
        DownSystemSiteDispatch downSystemSiteDispatch = DownSystemSiteDispatch.builder()
                .sourceDownSystemSiteId(1)
                .targetDownSystemSiteId(2)
                .matchPattern("^1$")
                .build();

        service.add(downSystemSiteDispatch);

    }


} 
