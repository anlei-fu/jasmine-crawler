/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Site;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSitePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteReq;
import com.jasmine.crawler.web.admin.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "site info")
@RestController
public class SiteController extends ControllerBase {

    @Autowired private SiteService siteService;

    @ApiOperation("add site")
    @PostMapping(path = "/site")
    public R add(@Validated @ModelAttribute AddSiteReq req) {
        boolean result = siteService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single site")
    @DeleteMapping(path = "/site/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = siteService.deleteById(id);
        return responseBoolean(result);
    }

    @ApiOperation("update single site")
    @PutMapping(path = "/site/{id}")
    public R updateById(@PathVariable Integer id, @Validated @ModelAttribute UpdateSiteReq req) {
        boolean result = siteService.updateById(id, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single site")
    @GetMapping(path = "/site/{id}")
    public R<Site> getById(@PathVariable Integer id) {
        Site result = siteService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get site page")
    @GetMapping(path = "/site/page")
    public R<PageResult<Site>> getPage(@Validated @ModelAttribute GetSitePageReq req) {
        PageResult<Site> result = siteService.getPage(req);
        return responseData(result);
    }
}
