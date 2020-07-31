/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteIpDelayMap;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpDelayMapPageReq;
import com.jasmine.crawler.web.admin.service.SiteIpDelayMapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SiteIpDelayMap")
@RestController
public class SiteIpDelayMapController extends ControllerBase {

    @Autowired private SiteIpDelayMapService siteIpDelayMapService;

    public R deleteBatch() {
        return null;
    }

    @ApiOperation("get siteIpDelayMap page")
    @GetMapping(path = "/siteIpDelayMap/page")
    public R<PageResult<SiteIpDelayMap>> getPage(
            @Validated @ModelAttribute GetSiteIpDelayMapPageReq req) {
        PageResult<SiteIpDelayMap> result = siteIpDelayMapService.getPage(req);
        return responseData(result);
    }
}
