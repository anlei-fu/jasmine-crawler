/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteIpBlockMap;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteIpBlockMapPageReq;
import com.jasmine.crawler.web.admin.service.SiteIpBlockMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class SiteIpBlockMapController extends ControllerBase {

    @Autowired
    private SiteIpBlockMapService siteIpBlockMapService;

    @DeleteMapping(path = "/siteIpBlockMap/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = siteIpBlockMapService.deleteBatch(ids);
        return success(
                String.format(
                        "excepted to delete %d, successfully deleted %d", ids.size(), success));
    }

    @GetMapping(path = "/siteIpBlockMap/page")
    public R<PageResult<SiteIpBlockMap>> getPage(
            @Validated @ModelAttribute GetSiteIpBlockMapPageReq req) {
        PageResult<SiteIpBlockMap> result = siteIpBlockMapService.getPage(req);
        return responseData(result);
    }
}
