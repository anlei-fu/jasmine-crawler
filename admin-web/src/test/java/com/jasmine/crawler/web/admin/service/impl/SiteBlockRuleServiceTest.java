/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.util.TestUtils;
import com.jasmine.crawler.web.admin.Application;
import com.jasmine.crawler.web.admin.controller.SiteBlockRuleController;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteBlockRulePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBlockRuleReq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * SiteBlockRuleService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Tue Jul 28 2020 16:23:11 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SiteBlockRuleServiceTest {

    @Autowired
    private SiteBlockRuleController controller;

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

        AddSiteBlockRuleReq req = new AddSiteBlockRuleReq();

        req.setDescription("avoid annoy thing to do");
        req.setSiteId(2);
        req.setHttpStatus(90);
        req.setCheckType(90);
        req.setKeywords("mock string");
        req.setPageResultType(0);
        req.setEnableStatus(1);

        R result = controller.add(req);

        TestUtils.printQuery(req, result);
    }

    /**
     * deleteById
     */
    @Test
    public void testDeleteById() {

        R result = controller.deleteById(8);

        TestUtils.print(result);
    }

    /**
     * updateById
     */
    @Test
    public void testUpdateById() {

        UpdateSiteBlockRuleReq req = new UpdateSiteBlockRuleReq();

        req.setDescription("this is description mock data segment");
        req.setSiteId(6);
        req.setHttpStatus(90);
        req.setCheckType(0);
        req.setKeywords("mock string");
        req.setPageResultType(90);
        req.setEnableStatus(0);

        R result = controller.updateById(1, req);

        TestUtils.printQuery(req, result);
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

        GetSiteBlockRulePageReq req = new GetSiteBlockRulePageReq();

        req.setSiteId(15);
        req.setHttpStatus(0);
        req.setCheckType(20);
        req.setPageResultType(0);
        req.setEnableStatus(0);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }

    /**
     * getDetailById
     */
    @Test
    public void testGetDetailById() {

    }

    /**
     * getDetailPage
     */
    @Test
    public void testGetDetailPage() {

        GetSiteBlockRulePageReq req = new GetSiteBlockRulePageReq();

        req.setSiteId(35);
        req.setHttpStatus(30);
        req.setCheckType(30);
        req.setPageResultType(0);
        req.setEnableStatus(0);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

    }

    @Test
    public void testDeleteBatch() {
        List<Integer> ids = new LinkedList<>();
        controller.deleteBatch(ids);
    }
}
