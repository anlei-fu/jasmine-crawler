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
import com.jasmine.crawler.web.admin.controller.ProxyController;
import com.jasmine.crawler.web.admin.pojo.req.AddProxyReq;
import com.jasmine.crawler.web.admin.pojo.req.GetProxyPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyReq;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProxyService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProxyServiceTest {

    @Autowired private ProxyController controller;

    @Before
    public void before() {}

    @After
    public void after() {}

    /** add */
    @Test
    public void testAdd() {

        AddProxyReq req = new AddProxyReq();

        req.setIp("192.168.0.56");
        req.setPort(20);
        req.setAccount("guest2");
        req.setPassword("123456");
        req.setProtocol("mock string");
        req.setProxyType(30);
        req.setMaxUseCount(12);
        req.setBlockMaxCount(0);
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

        UpdateProxyReq req = new UpdateProxyReq();

        req.setIp("192.168.0.4");
        req.setPort(90);
        req.setAccount("admin");
        req.setPassword("122189");
        req.setProtocol("mock string");
        req.setProxyType(0);
        req.setMaxUseCount(6142);
        req.setBlockMaxCount(0);
        req.setEnableStatus(1);

        R result = controller.updateById(35, req);

        TestUtils.printQuery(req, result);
    }

    /** getById */
    @Test
    public void testGetById() {

        R result = controller.getById(29);

        TestUtils.print(result);
    }

    /** getPage */
    @Test
    public void testGetPage() {

        GetProxyPageReq req = new GetProxyPageReq();

        req.setProxyType(90);
        req.setEnableStatus(0);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
