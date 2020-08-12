/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddCrawlerReq;
import com.jasmine.crawler.web.admin.pojo.req.GetCrawlerPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerReq;
import com.jasmine.crawler.web.admin.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CrawlerController extends ControllerBase {

    @Autowired
    private CrawlerService crawlerService;

    @PostMapping(path = "/crawler")
    public R add(@RequestBody @Validated AddCrawlerReq req) {
        boolean result = crawlerService.add(req);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/crawler/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = crawlerService.deleteById(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/crawler/delete/batch")
    public R deleteBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = crawlerService.deleteBatch(ids);
        return success(
                String.format("expect to delete %d, successfully deleted %d", ids.size(), success));
    }

    @PutMapping(path = "/crawler/disable/batch")
    public R disableBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to disable");

        int success = crawlerService.disableBatch(ids);
        return success(
                String.format(
                        "expect to disable %d, successfully disabled %d", ids.size(), success));
    }

    @PutMapping(path = "/crawler/enable/batch")
    public R enableBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to enable");

        int success = crawlerService.enableBatch(ids);
        return success(
                String.format("expect to enable %d, successfully enabled %d", ids.size(), success));
    }

    @PutMapping(path = "/crawler/{id}")
    public R updateById(@PathVariable Integer id, @RequestBody @Validated UpdateCrawlerReq req) {
        boolean result = crawlerService.updateById(id, req);
        return responseBoolean(result);
    }

    @PutMapping(path = "/crawler/update/batch")
    public R updateBatch(@RequestBody UpdateCrawlerBatchReq req) {
        if (Objects.isNull(req.getIds()) || req.getIds().size() == 0)
            return failed("no data to update");

        int success = crawlerService.updateBatch(req);
        return success(String.format(
                "excepted to update %d data,actual succeed %d ",
                req.getIds().size(),
                success)
        );
    }

    @GetMapping(path = "/crawler/{id}")
    public R<Crawler> getById(@PathVariable Integer id) {
        Crawler result = crawlerService.getById(id);
        return responseData(result);
    }

    @GetMapping(path = "/crawler/page")
    public R<PageResult<Crawler>> getPage(@Validated GetCrawlerPageReq req) {
        PageResult<Crawler> result = crawlerService.getPage(req);
        return responseData(result);
    }
}
