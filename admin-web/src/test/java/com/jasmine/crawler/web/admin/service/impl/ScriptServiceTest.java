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
import com.jasmine.crawler.web.admin.controller.ScriptController;
import com.jasmine.crawler.web.admin.pojo.req.AddScriptReq;
import com.jasmine.crawler.web.admin.pojo.req.GetScriptPageReq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ScriptService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ScriptServiceTest {

    @Autowired
    private ScriptController controller;

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

        AddScriptReq req = new AddScriptReq();

        req.setDescription("jasmine code generator, generate every thing you need");
        req.setPath("g://google.bmp");
        req.setScriptType(0);
        req.setDownSiteId(35);
        req.setEnableStatus(0);

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /**
     * deleteById
     */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(6);

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

        R result = controller.getById(1);

        TestUtils.print(result);
    }

    /**
     * getPage
     */
    @Test
    public void testGetPage() {

        GetScriptPageReq req = new GetScriptPageReq();

        req.setScriptType(90);
        req.setEnableStatus(0);

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
