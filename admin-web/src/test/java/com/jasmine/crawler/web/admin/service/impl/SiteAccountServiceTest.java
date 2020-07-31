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
import com.jasmine.crawler.web.admin.controller.SiteAccountController;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteAccountReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteAccountPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountReq;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SiteAccountService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteAccountServiceTest {

    @Autowired private SiteAccountController controller;

    @Before
    public void before() {}

    @After
    public void after() {}

    /** add */
    @Test
    public void testAdd() {

        AddSiteAccountReq req = new AddSiteAccountReq();

        req.setNickName("calla");
        req.setDescription("this is description mock data segment");
        req.setLoginType(0);
        req.setSiteId(8);
        req.setPhone("15878956321");
        req.setEmail("18009049263@gmial.com");
        req.setPassword("administrator");
        req.setLastLoginIp("192.168.0.9");
        req.setEnableStatus(0);

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

        UpdateSiteAccountReq req = new UpdateSiteAccountReq();

        req.setNickName("narcissus");
        req.setDescription("this is description mock data segment");
        req.setLoginType(30);
        req.setSiteId(15);
        req.setPhone("18009049263");
        req.setEmail("18102345622@ms.com");
        req.setPassword("1qaz2wsx");
        req.setLastLoginIp("192.168.0.3");
        req.setEnableStatus(0);

        R result = controller.updateById(15, req);

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

        GetSiteAccountPageReq req = new GetSiteAccountPageReq();

        req.setLoginType(0);
        req.setSiteId(29);
        req.setEnableStatus(0);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
