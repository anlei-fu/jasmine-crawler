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
import com.jasmine.crawler.web.admin.controller.SiteController;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteReq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SiteService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteServiceTest {

    @Autowired
    private SiteController controller;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    /**
     * add
     */
    @Test
    public void testAdd() {

        AddSiteReq req = new AddSiteReq();

        req.setName("rose");
        req.setDomain("http://www.msdn.com");
        req.setDescription("avoid annoy thing to do");
        req.setHomePageUrl("http://www.google.com");
        req.setParentSiteId(15);
        req.setNeedUseCookie(0);
        req.setLoginScriptId(7);
        req.setLoginNeedVcode(0);
        req.setLoginCaptaType(90);
        req.setNeedUseProxy(1);
        req.setIpDelayTimeout(20);
        req.setIpBlockTimeout(30);
        req.setIpHourSpeedLimit(0);
        req.setIpMinuteSpeedLimit(20);
        req.setIpDaySpeedLimit(20);
        req.setAccountAllowCrossIp(899);
        req.setAccountAllowMultiple(1);
        req.setAccountMinuteSpeedLimit(56589);
        req.setAccountHourSpeedLimit(899);
        req.setAccountDaySpeedLimit(12);
        req.setAccountMaxBlockCount(0);
        req.setAccountBlockTimeout(12);
        req.setAccountMaxCookieCount(56589);
        req.setAccountDelayTimeout(0);
        req.setCookieMaxBlockCount(56589);
        req.setCookieExpireTimeout(30);
        req.setCookieDelayTimeout(90);
        req.setEnableStatus(1);

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /**
     * deleteById
     */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(7);

        TestUtils.print(result);
    }

    /**
     * updateById
     */
    @Test
    public void testUpdateById() {

        UpdateSiteReq req = new UpdateSiteReq();

        req.setName("jasmine");
        req.setDomain("http://www.163.com");
        req.setDescription("this is description mock data segment");
        req.setHomePageUrl("http://www.qq.com");
        req.setParentSiteId(8);
        req.setNeedUseCookie(90);
        req.setLoginScriptId(8);
        req.setLoginNeedVcode(20);
        req.setLoginCaptaType(30);
        req.setNeedUseProxy(1);
        req.setIpDelayTimeout(20);
        req.setIpBlockTimeout(90);
        req.setIpHourSpeedLimit(0);
        req.setIpMinuteSpeedLimit(30);
        req.setIpDaySpeedLimit(0);
        req.setAccountAllowCrossIp(899);
        req.setAccountAllowMultiple(12);
        req.setAccountMinuteSpeedLimit(12);
        req.setAccountHourSpeedLimit(1984);
        req.setAccountDaySpeedLimit(6142);
        req.setAccountMaxBlockCount(12);
        req.setAccountBlockTimeout(6142);
        req.setAccountMaxCookieCount(56589);
        req.setAccountDelayTimeout(899);
        req.setCookieMaxBlockCount(899);
        req.setCookieExpireTimeout(90);
        req.setCookieDelayTimeout(20);
        req.setEnableStatus(1);

        R result = controller.updateById(1, req);

        TestUtils.printQuery(req, result);
    }

    /**
     * getById
     */
    @Test
    public void testGetById() {

        R result = controller.getById(7);

        TestUtils.print(result);
    }

    /**
     * getPage
     */
    @Test
    public void testGetPage() {

        GetSitePageReq req = new GetSitePageReq();

        req.setParentSiteId(35);
        req.setLoginScriptId(8);
        req.setLoginCaptaType(20);
        req.setNeedUseProxy(0);
        req.setEnableStatus(1);

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
