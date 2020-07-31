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
import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryReq;
import com.jasmine.crawler.web.admin.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "enum value- name map")
@RestController
public class DictionaryController extends ControllerBase {

    @Autowired private DictionaryService dictionaryService;

    @ApiOperation("add dictionary")
    @PostMapping(path = "/dictionary")
    public R add(
            @SessionAttribute("userId") String createUser,
            @Validated @ModelAttribute AddDictionaryReq req) {
        boolean result = dictionaryService.add(createUser, req);
        return responseBoolean(result);
    }

    @ApiOperation("delete single dictionary")
    @DeleteMapping(path = "/dictionary/{id}")
    public R deleteById(@PathVariable Integer id) {
        boolean result = dictionaryService.deleteById(id);
        return responseBoolean(result);
    }

    @DeleteMapping(path = "/dictionary/delete/batch")
    public R deleteBatch(List<Integer> ids) {
        if (Objects.isNull(ids) || ids.size() == 0) return failed("no id to remove");

        int count = dictionaryService.deleteBatch(ids);
        return success(
                String.format("excepted to delete %d, successfully deleted %d", ids.size(), count));
    }

    @PutMapping(path = "/dictionary/update/type/batch")
    public R updateTypeBatch() {
        return null;
    }

    @ApiOperation("update single dictionary")
    @PutMapping(path = "/dictionary/{id}")
    public R updateById(
            @PathVariable Integer id,
            @SessionAttribute("userId") String lastUpdateUser,
            @Validated @ModelAttribute UpdateDictionaryReq req) {
        boolean result = dictionaryService.updateById(id, lastUpdateUser, req);
        return responseBoolean(result);
    }

    @ApiOperation("get single dictionary")
    @GetMapping(path = "/dictionary/{id}")
    public R<Dictionary> getById(@PathVariable Integer id) {
        Dictionary result = dictionaryService.getById(id);
        return responseData(result);
    }

    @ApiOperation("get dictionary page")
    @GetMapping(path = "/dictionary/page")
    public R<PageResult<Dictionary>> getPage(@Validated @ModelAttribute GetDictionaryPageReq req) {
        PageResult<Dictionary> result = dictionaryService.getPage(req);
        return responseData(result);
    }
}
