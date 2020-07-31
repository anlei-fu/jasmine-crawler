/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddCookieReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCookiePageReq;
import com.jasmine.crawler.web.admin.service.CookieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Cookie")
@RestController
public class CookieController extends ControllerBase {

    @Autowired private CookieService cookieService;

    @ApiOperation("add cookie")
    @PostMapping(path = "/cookie")
    public R add(@Validated @ModelAttribute AddCookieReq req) {
        boolean result = cookieService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single cookie")
    @DeleteMapping(path = "/cookie/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = cookieService.deleteById(id);
        return responseBoolean(result);
    }

    @PutMapping(path = "/cookie/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = cookieService.deleteBatch(ids);
        return success(
                String.format(
                        "excepted to delete %d, successfully deleted %d", ids.size(), success));
    }

    @ApiOperation("get single cookie")
    @GetMapping(path = "/cookie/{id}")
    public R<Cookie> getById(@PathVariable Integer id) {
        Cookie result = cookieService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get cookie page")
    @GetMapping(path = "/cookie/page")
    public R<PageResult<Cookie>> getPage(@Validated @ModelAttribute GetCookiePageReq req) {
        PageResult<Cookie> result = cookieService.getPage(req);
        return responseData(result);
    }
}
