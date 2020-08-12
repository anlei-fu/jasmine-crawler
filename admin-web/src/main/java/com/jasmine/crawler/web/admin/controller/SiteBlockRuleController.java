/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteBlockRule;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.pojo.req.GetSiteBlockRulePageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBlockRuleReq;
import com.jasmine.crawler.web.admin.service.SiteBlockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class SiteBlockRuleController extends ControllerBase {

    @Autowired
    private SiteBlockRuleService siteBlockRuleService;

    @PostMapping(path = "/siteBlockRule")
    public R add(@RequestBody @Validated AddSiteBlockRuleReq req) {
        boolean result = siteBlockRuleService.add(req);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/siteBlockRule/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = siteBlockRuleService.deleteById(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/siteBlockRule/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = siteBlockRuleService.deleteBatch(ids);
        return success(
                String.format(
                        "excepted to delete %d, successfully deleted %d", ids.size(), success));
    }

    @PutMapping(path = "/siteBlockRule/{id}")
    public R updateById(
            @PathVariable Integer id, @Validated @ModelAttribute UpdateSiteBlockRuleReq req) {
        boolean result = siteBlockRuleService.updateById(id, req);
        return responseBoolean(result);
    }

    @GetMapping(path = "/siteBlockRule/{id}")
    public R<SiteBlockRule> getById(@PathVariable Integer id) {
        SiteBlockRule result = siteBlockRuleService.getById(id);
        return responseData(result);
    }

    @GetMapping(path = "/siteBlockRule/page")
    public R<PageResult<SiteBlockRule>> getPage(
            @Validated @ModelAttribute GetSiteBlockRulePageReq req) {
        PageResult<SiteBlockRule> result = siteBlockRuleService.getPage(req);
        return responseData(result);
    }

}
