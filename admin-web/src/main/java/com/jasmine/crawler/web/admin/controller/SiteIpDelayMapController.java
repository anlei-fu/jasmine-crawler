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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class SiteIpDelayMapController extends ControllerBase {

    @Autowired
    private SiteIpDelayMapService siteIpDelayMapService;

    @DeleteMapping(path = "/siteIpDelayMap/{id}")
    public R deleteById(@PathVariable("id") Integer id) {
        boolean result = siteIpDelayMapService.deleteById(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/siteIpDelayMap/delete/batch")
    public R deleteBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = siteIpDelayMapService.deleteBatch(ids);
        return success(
                String.format("expect to delete %d, successfully deleted %d", ids.size(), success));
    }

    @GetMapping(path = "/siteIpDelayMap/page")
    public R<PageResult<SiteIpDelayMap>> getPage(
            @Validated GetSiteIpDelayMapPageReq req) {
        PageResult<SiteIpDelayMap> result = siteIpDelayMapService.getPage(req);
        return responseData(result);
    }
}
