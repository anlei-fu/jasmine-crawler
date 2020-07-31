/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Script;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddScriptReq;
import com.jasmine.crawler.web.admin.pojo.req.GetScriptPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateScriptReq;
import com.jasmine.crawler.web.admin.service.ScriptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "script info")
@RestController
public class ScriptController extends ControllerBase {

    @Autowired private ScriptService scriptService;

    @ApiOperation("add script")
    @PostMapping(path = "/script")
    public R add(@Validated @ModelAttribute AddScriptReq req) {
        boolean result = scriptService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single script")
    @DeleteMapping(path = "/script/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = scriptService.deleteById(id);
        return responseBoolean(result);
    }

    @ApiOperation("update single script")
    @PutMapping(path = "/script/{id}")
    public R updateById(@PathVariable Integer id, @Validated @ModelAttribute UpdateScriptReq req) {
        boolean result = scriptService.updateById(id, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single script")
    @GetMapping(path = "/script/{id}")
    public R<Script> getById(@PathVariable Integer id) {
        Script result = scriptService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get script page")
    @GetMapping(path = "/script/page")
    public R<PageResult<Script>> getPage(@Validated @ModelAttribute GetScriptPageReq req) {
        PageResult<Script> result = scriptService.getPage(req);
        return responseData(result);
    }
}
