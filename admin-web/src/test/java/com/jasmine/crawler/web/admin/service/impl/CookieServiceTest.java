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
import com.jasmine.crawler.web.admin.controller.CookieController;
import com.jasmine.crawler.web.admin.pojo.req.AddCookieReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCookiePageReq;
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
 * CookieService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CookieServiceTest {

    @Autowired
    private CookieController controller;

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

        AddCookieReq req = new AddCookieReq();

        req.setSiteAccountId(12);
        req.setCookie("mock string");
        req.setLoginIp("192.168.0.1");

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /**
     * deleteById
     */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(29);

        TestUtils.print(result);
    }

    /**
     * updateById
     */
    @Test
    public void testUpdateById() {

    }

    /**
     * getById
     */
    @Test
    public void testGetById() {

        R result = controller.getById(35);

        TestUtils.print(result);
    }

    /**
     * getPage
     */
    @Test
    public void testGetPage() {

        GetCookiePageReq req = new GetCookiePageReq();

        req.setSiteAccountId(12);

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }

    @Test
    public void testDeleteBatch() {
        List<Integer> ids = new LinkedList<>();
        controller.deleteBatch(ids);
    }
}
