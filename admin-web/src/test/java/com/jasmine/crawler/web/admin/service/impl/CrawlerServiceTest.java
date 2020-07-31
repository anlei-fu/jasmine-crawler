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
import com.jasmine.crawler.web.admin.controller.CrawlerController;
import com.jasmine.crawler.web.admin.pojo.req.AddCrawlerReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlerPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerReq;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CrawlerService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CrawlerServiceTest {

    @Autowired private CrawlerController controller;

    @Before
    public void before() {}

    @After
    public void after() {}

    /** add */
    @Test
    public void testAdd() {

        AddCrawlerReq req = new AddCrawlerReq();

        req.setClientVersion(30);
        req.setName("calla");
        req.setIp("192.168.0.2");
        req.setDescription("this is description mock data segment");
        req.setCrawlerType(30);
        req.setKey("mock string");
        req.setUniqueId("mock string");
        req.setPort(30);
        req.setMaxConcurrency(0);
        req.setEnableStatus(1);

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /** deleteById */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(1);

        TestUtils.print(result);
    }

    /** updateById */
    @Test
    public void testUpdateById() {

        UpdateCrawlerReq req = new UpdateCrawlerReq();

        req.setClientVersion(90);
        req.setName("jasmine");
        req.setIp("192.168.0.1");
        req.setDescription("mock generator, generate lots of data for testing");
        req.setCrawlerType(20);
        req.setKey("mock string");
        req.setUniqueId("mock string");
        req.setPort(0);
        req.setMaxConcurrency(90);
        req.setCurrentConcurrency(20);
        req.setEnableStatus(1);

        R result = controller.updateById(1, req);

        TestUtils.printQuery(req, result);
    }

    /** getById */
    @Test
    public void testGetById() {

        R result = controller.getById(15);

        TestUtils.print(result);
    }

    /** getPage */
    @Test
    public void testGetPage() {

        GetCrawlerPageReq req = new GetCrawlerPageReq();

        req.setCrawlerType(90);
        req.setUniqueId("mock string");
        req.setHeartbeatStatus(0);
        req.setEnableStatus(1);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
