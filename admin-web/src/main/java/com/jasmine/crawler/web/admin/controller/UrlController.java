/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddUrlReq;
import com.jasmine.crawler.web.admin.pojo.req.GetUrlPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import com.jasmine.crawler.web.admin.service.UrlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "url info")
@RestController
public class UrlController extends ControllerBase {

    @Autowired private UrlService urlService;

    @ApiOperation("add url")
    @PostMapping(path = "/url")
    public R add(@Validated @ModelAttribute AddUrlReq req) {
        boolean result = urlService.add(req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single url")
    @DeleteMapping(path = "/url/{url}")
    public R deleteByUrl(@PathVariable String url) {
        boolean result = urlService.deleteByUrl(url);
        return responseBoolean(result);
    }

    @ApiOperation("update single url")
    @PutMapping(path = "/url/{url}")
    public R updateByUrl(@PathVariable String url, @Validated @ModelAttribute UpdateUrlReq req) {
        boolean result = urlService.updateByUrl(url, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single url")
    @GetMapping(path = "/url/{url}")
    public R<Url> getByUrl(@PathVariable String url) {
        Url result = urlService.getByUrl(url);
        return responseData(result);
    }

    public R deleteBatch() {
        return null;
    }

    @ApiOperation("get url page")
    @GetMapping(path = "/url/page")
    public R<PageResult<Url>> getPage(@Validated @ModelAttribute GetUrlPageReq req) {
        PageResult<Url> result = urlService.getPage(req);
        return responseData(result);
    }
}
