/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteUrlBloomPageReq;
import com.jasmine.crawler.web.admin.service.SiteUrlBloomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "site-url bloom  ")
@RestController
public class SiteUrlBloomController extends ControllerBase {

    @Autowired private SiteUrlBloomService siteUrlBloomService;

    @ApiOperation("get single siteUrlBloom")
    @GetMapping(path = "/siteUrlBloom/{id}")
    public R<SiteUrlBloom> getById(@PathVariable Integer id) {
        SiteUrlBloom result = siteUrlBloomService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get siteUrlBloom page")
    @GetMapping(path = "/siteUrlBloom/page")
    public R<PageResult<SiteUrlBloom>> getPage(
            @Validated @ModelAttribute GetSiteUrlBloomPageReq req) {
        PageResult<SiteUrlBloom> result = siteUrlBloomService.getPage(req);
        return responseData(result);
    }
}
