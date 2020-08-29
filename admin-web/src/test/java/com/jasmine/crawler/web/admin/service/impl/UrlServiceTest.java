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
import com.jasmine.crawler.web.admin.controller.UrlController;
import com.jasmine.crawler.web.admin.pojo.req.GetUrlPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * UrlService Tester.
 *
 * @author fuanlei
 * @version 1.0
 * @since Fri Jul 31 2020 21:09:23 GMT+0800 (GMT+08:00)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UrlServiceTest {

    @Autowired
    private UrlController controller;

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

        //        AddUrlReq req = new AddUrlReq();
        //
        //        req.setDepth(20);
        //        req.setDownSystemSiteId(2);
        //        req.setUrlType(20);
        //        req.setReferUrl("http://www.bbc.co.uk");
        //        req.setCrawlCount(56589);
        //        req.setUrlStatus(90);
        //        req.setLastCrawlTime("2008-12-06");
        //        req.setQueryString("mock string");
        //
        //        R result = controller.add(
        //
        //                req
        //
        //        );

        //        TestUtils.printQuery(req, result);

    }

    /**
     * deleteByUrl
     */
    @Test
    public void testDeleteByUrl() {

        R result = controller.deleteById("http://www.qq.com");

        TestUtils.print(result);
    }

    /**
     * updateByUrl
     */
    @Test
    public void testUpdateByUrl() {

        UpdateUrlReq req = new UpdateUrlReq();

        req.setDepth(20);
        req.setDownSystemSiteId(1);
        req.setUrlType(0);
        req.setReferUrl("http://www.msdn.com");
        req.setCrawlCount(899);
        req.setUrlStatus(90);
        req.setLastCrawlTime("2008-12-06");
        req.setQueryString("mock string");

        R result = controller.updateByUrl("http://www.qq.com", req);

        TestUtils.printQuery(req, result);
    }

    /**
     * getByUrl
     */
    @Test
    public void testGetByUrl() {

        R result = controller.getByUrl("http://www.163.com");

        TestUtils.print(result);
    }

    /**
     * getPage
     */
    @Test
    public void testGetPage() {

        GetUrlPageReq req = new GetUrlPageReq();

        req.setDownSystemSiteId(8);
        req.setUrlType(20);
        req.setUrlStatus(20);
        req.setCreateTimeStart(new Date());
        req.setCreateTimeEnd(new Date());

        R result = controller.getPage(req);

        TestUtils.printQuery(req, result);
    }
}
