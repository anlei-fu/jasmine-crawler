/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystem;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddDownSystemReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDownSystemPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemReq;
import com.jasmine.crawler.web.admin.service.DownSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "DownSystem")
@RestController
public class DownSystemController extends ControllerBase {

    @Autowired private DownSystemService downSystemService;

    @ApiOperation("add downSystem")
    @PostMapping(path = "/downSystem")
    public R add(@Validated @ModelAttribute AddDownSystemReq req) {
        boolean result = downSystemService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single downSystem")
    @DeleteMapping(path = "/downSystem/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = downSystemService.deleteById(id);
        return responseBoolean(result);
    }

    @ApiOperation("update single downSystem")
    @PutMapping(path = "/downSystem/{id}")
    public R updateById(
            @PathVariable Integer id, @Validated @ModelAttribute UpdateDownSystemReq req) {
        boolean result = downSystemService.updateById(id, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single downSystem")
    @GetMapping(path = "/downSystem/{id}")
    public R<DownSystem> getById(@PathVariable Integer id) {
        DownSystem result = downSystemService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get downSystem page")
    @GetMapping(path = "/downSystem/page")
    public R<PageResult<DownSystem>> getPage(@Validated @ModelAttribute GetDownSystemPageReq req) {
        PageResult<DownSystem> result = downSystemService.getPage(req);
        return responseData(result);
    }
}
