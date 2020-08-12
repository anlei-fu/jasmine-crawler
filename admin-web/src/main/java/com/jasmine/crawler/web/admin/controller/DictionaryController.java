/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Dictionary;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.AddDictionaryReq;
import com.jasmine.crawler.web.admin.pojo.req.GetDictionaryPageReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryBatchReq;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryReq;
import com.jasmine.crawler.web.admin.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class DictionaryController extends ControllerBase {

    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping(path = "/dictionary")
    public R add(@RequestBody AddDictionaryReq req) {
        boolean result = dictionaryService.add(req);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/dictionary/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = dictionaryService.deleteById(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/dictionary/delete/batch")
    public R deleteBatch(@RequestBody List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int success = dictionaryService.deleteBatch(ids);
        return success(
                String.format("excepted to delete %d, successfully deleted %d", ids.size(), success));
    }

    @PutMapping(path = "/dictionary/update/batch")
    public R updateBatch(@RequestBody UpdateDictionaryBatchReq req) {
        if (Objects.isNull(req.getIds()) || req.getIds().size() == 0)
            return failed("no data to update");

        int success = dictionaryService.updateBatch(req);
        return success(String.format(
                "excepted to update %d data,actual succeed %d ",
                req.getIds().size(),
                success)
        );
    }

    @PutMapping(path = "/dictionary/{id}")
    public R updateById(
            @PathVariable Integer id,
            @RequestBody UpdateDictionaryReq req) {
        boolean result = dictionaryService.updateById(id, req);
        return responseBoolean(result);
    }

    @GetMapping(path = "/dictionary/{id}")
    public R<Dictionary> getById(@PathVariable Integer id) {
        Dictionary result = dictionaryService.getById(id);
        return responseData(result);
    }

    @GetMapping(path = "/dictionary/page")
    public R<PageResult<Dictionary>> getPage(@Validated @ModelAttribute GetDictionaryPageReq req) {
        PageResult<Dictionary> result = dictionaryService.getPage(req);
        return responseData(result);
    }

    @GetMapping(path = "/dictionary/all")
    public R<List<Dictionary>> getAll() {
        List<Dictionary> result = dictionaryService.getAll();
        return responseData(result);
    }
}
