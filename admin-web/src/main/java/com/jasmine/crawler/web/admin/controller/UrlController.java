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
import com.jasmine.crawler.web.admin.pojo.req.AddSeedUrlReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import com.jasmine.crawler.web.admin.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlController extends ControllerBase {

    @Autowired
    private UrlService urlService;

    @PostMapping(path = "/url/seed")
    public R addSeedUrl( @RequestBody @Validated AddSeedUrlReq req) {
        boolean result = urlService.addSeedUrl(req);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/url/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = urlService.delete(id);
        return responseBoolean(result);
    }

    @PutMapping(path = "/url/{url}")
    public R updateByUrl(@PathVariable String url, @Validated UpdateUrlReq req) {
        boolean result = urlService.updateByUrl(url, req);
        return responseBoolean(result);
    }

    @GetMapping(path = "/url/{url}")
    public R<Url> getByUrl(@PathVariable String url) {
        Url result = urlService.getByUrl(url);
        return responseData(result);
    }

    public R deleteBatch() {
        return null;
    }

    @GetMapping(path = "/url/getSeedUrlByDownSystemSiteId/{downSystemSiteId}")
    public R<List<Url>> getSeedUrlByDownSystemSIteId(@PathVariable Integer downSystemSiteId) {
        List<Url> result = urlService.getSeedUrlByDownSystemSIteId(downSystemSiteId);
        return responseData(result);
    }
}
