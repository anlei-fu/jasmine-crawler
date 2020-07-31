/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.web.admin.Application;
import com.jasmine.crawler.web.admin.TestUtils;
import com.jasmine.crawler.web.admin.controller.DownSystemController;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemReq;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * DownSystemService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DownSystemServiceTest {

    @Autowired private DownSystemController controller;

    @Before
    public void before() {}

    @After
    public void after() {}

    /** add */
    @Test
    public void testAdd() {

        AddDownSystemReq req = new AddDownSystemReq();

        req.setName("calla");
        req.setPriority(0);
        req.setDescription("jasmine code generator, generate every thing you need");
        req.setAppKey("mock string");
        req.setAppSecret("mock string");
        req.setDataUrl("https://www.baidu.com");
        req.setDataQueue("mock string");
        req.setTaskMaxRunningCount(0);
        req.setEnableStatus(1);

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /** deleteById */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(6);

        TestUtils.print(result);
    }

    /** updateById */
    @Test
    public void testUpdateById() {

        UpdateDownSystemReq req = new UpdateDownSystemReq();

        req.setName("lily");
        req.setPriority(90);
        req.setDescription("this is description mock data segment");
        req.setAppKey("mock string");
        req.setAppSecret("mock string");
        req.setDataUrl("http://www.qq.com");
        req.setDataQueue("mock string");
        req.setTaskMaxRunningCount(0);
        req.setTaskCurrentRunningCount(899);
        req.setUrlTotalCount(56589);
        req.setUrlFinishedCount(6142);
        req.setUrlBadCount(6142);
        req.setEnableStatus(0);

        R result = controller.updateById(35, req);

        TestUtils.printQuery(req, result);
    }

    /** getById */
    @Test
    public void testGetById() {

        R result = controller.getById(8);

        TestUtils.print(result);
    }

    /** getPage */
    @Test
    public void testGetPage() {

        GetDownSystemPageReq req = new GetDownSystemPageReq();

        req.setEnableStatus(1);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
