/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteAccountReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteAccountPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountReq;
import com.jasmine.crawler.web.admin.service.SiteAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "site account info")
@RestController
public class SiteAccountController extends ControllerBase {

    @Autowired private SiteAccountService siteAccountService;

    @ApiOperation("add siteAccount")
    @PostMapping(path = "/siteAccount")
    public R add(@Validated @ModelAttribute AddSiteAccountReq req) {
        boolean result = siteAccountService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single siteAccount")
    @DeleteMapping(path = "/siteAccount/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = siteAccountService.deleteById(id);
        return responseBoolean(result);
    }

    @PostMapping(path = "/siteAccount/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = siteAccountService.deleteBatch(ids);
        return success(
                String.format("expect to delete %d, successfully deleted %d", ids.size(), success));
    }

    @PutMapping(path = "/siteAccount/disable/batch")
    public R disableBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to disable");

        int success = siteAccountService.disableBatch(ids);
        return success(
                String.format(
                        "expect to disable %d, successfully disabled %d", ids.size(), success));
    }

    @PutMapping(path = "/siteAccount/enable/batch")
    public R enableBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to enable");

        int success = siteAccountService.enableBatch(ids);
        return success(
                String.format("expect to enable %d, successfully enabled %d", ids.size(), success));
    }

    @ApiOperation("update single siteAccount")
    @PutMapping(path = "/siteAccount/{id}")
    public R updateById(
            @PathVariable Integer id, @Validated @ModelAttribute UpdateSiteAccountReq req) {
        boolean result = siteAccountService.updateById(id, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single siteAccount")
    @GetMapping(path = "/siteAccount/{id}")
    public R<SiteAccount> getById(@PathVariable Integer id) {
        SiteAccount result = siteAccountService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get siteAccount page")
    @GetMapping(path = "/siteAccount/page")
    public R<PageResult<SiteAccount>> getPage(
            @Validated @ModelAttribute GetSiteAccountPageReq req) {
        PageResult<SiteAccount> result = siteAccountService.getPage(req);
        return responseData(result);
    }
}
