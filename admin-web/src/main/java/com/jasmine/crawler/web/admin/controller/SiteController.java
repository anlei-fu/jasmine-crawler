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
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteReq;
import com.jasmine.crawler.web.admin.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class SiteController extends ControllerBase {

    @Autowired
    private SiteService siteService;

    @PostMapping(path = "/site")
    public R add(@RequestBody @Validated AddSiteReq req) {
        boolean result = siteService.add(req);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/site/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = siteService.deleteById(id);
        return responseBoolean(result);
    }

    @PutMapping(path = "/site/{id}")
    public R updateById(@PathVariable Integer id, @RequestBody @Validated UpdateSiteReq req) {
        boolean result = siteService.updateById(id, req);
        return responseBoolean(result);
    }

    @PutMapping(path = "/site/update/batch")
    public R updateBatch(@RequestBody UpdateSiteBatchReq req) {
        if (Objects.isNull(req.getIds()) || req.getIds().size() == 0)
            return failed("no data to update");

        int success = siteService.updateBatch(req);
        return success(String.format(
                "excepted to update %d data,actual succeed %d ",
                req.getIds().size(),
                success)
        );
    }

    @GetMapping(path = "/site/{id}")
    public R<Site> getById(@PathVariable Integer id) {
        Site result = siteService.getById(id);
        return responseData(result);
    }

    @GetMapping(path = "/site/page")
    public R<PageResult<Site>> getPage(@Validated GetSitePageReq req) {
        PageResult<Site> result = siteService.getPage(req);
        return responseData(result);
    }
}
