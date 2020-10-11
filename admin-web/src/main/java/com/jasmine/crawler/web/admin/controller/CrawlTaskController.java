/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlTaskPageReq;
import com.jasmine.crawler.web.admin.pojo.vo.CrawlTaskDetail;
import com.jasmine.crawler.web.admin.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlTaskController extends ControllerBase {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @GetMapping(path = "/crawlTask/page")
    public R<PageResult<CrawlTaskDetail>> getPage(@Validated GetCrawlTaskPageReq req) {
        PageResult<CrawlTaskDetail> result = crawlTaskService.getPage(req);
        return responseData(result);
    }
}
