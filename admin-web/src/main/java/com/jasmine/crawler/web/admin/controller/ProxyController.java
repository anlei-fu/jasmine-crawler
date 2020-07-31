/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddProxyReq;
import com.jasmine.crawler.web.admin.pojo.req.GetProxyPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyReq;
import com.jasmine.crawler.web.admin.service.ProxyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "proxy info")
@RestController
public class ProxyController extends ControllerBase {

    @Autowired private ProxyService proxyService;

    @ApiOperation("add proxy")
    @PostMapping(path = "/proxy")
    public R add(@Validated @ModelAttribute AddProxyReq req) {
        boolean result = proxyService.add(req);
        return responseBoolean(result);
    }

    @PostMapping(path = "/proxy/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = proxyService.deleteBatch(ids);
        return success(
                String.format("expect to delete %d, successfully deleted %d", ids.size(), success));
    }

    @PutMapping(path = "/proxy/disable/batch")
    public R disableBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to disable");

        int success = proxyService.disableBatch(ids);
        return success(
                String.format(
                        "expect to disable %d, successfully disabled %d", ids.size(), success));
    }

    @PutMapping(path = "/proxy/enable/batch")
    public R enableBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to enable");

        int success = proxyService.enableBatch(ids);
        return success(
                String.format("expect to enable %d, successfully enabled %d", ids.size(), success));
    }

    @ApiOperation("update single proxy")
    @PutMapping(path = "/proxy/{id}")
    public R updateById(@PathVariable Integer id, @Validated @ModelAttribute UpdateProxyReq req) {
        boolean result = proxyService.updateById(id, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single proxy")
    @GetMapping(path = "/proxy/{id}")
    public R<Proxy> getById(@PathVariable Integer id) {
        Proxy result = proxyService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get proxy page")
    @GetMapping(path = "/proxy/page")
    public R<PageResult<Proxy>> getPage(@Validated @ModelAttribute GetProxyPageReq req) {
        PageResult<Proxy> result = proxyService.getPage(req);
        return responseData(result);
    }
}
