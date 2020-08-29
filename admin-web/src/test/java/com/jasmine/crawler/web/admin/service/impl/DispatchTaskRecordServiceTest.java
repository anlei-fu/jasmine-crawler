/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.util.TestUtils;
import com.jasmine.crawler.web.admin.Application;
import com.jasmine.crawler.web.admin.controller.DispatchRecordController;
import com.jasmine.crawler.web.admin.pojo.req.GetDispatchTaskRecordPageReq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DispatchTaskRecordService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DispatchTaskRecordServiceTest {

    @Autowired
    private DispatchRecordController controller;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    /**
     * getPage
     */
    @Test
    public void testGetPage() {

        GetDispatchTaskRecordPageReq req = new GetDispatchTaskRecordPageReq();

        req.setCrawlTaskId(8);
        req.setDispatchResult(20);

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
