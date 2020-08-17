/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DispatchRecord;
import com.jasmine.crawler.common.pojo.resp.PageResult;
import com.jasmine.crawler.web.admin.pojo.req.GetDispatchTaskRecordPageReq;
import com.jasmine.crawler.web.admin.service.DispatchTaskRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DispatchRecordController extends ControllerBase {

    @Autowired
    private DispatchTaskRecordService dispatchTaskRecordService;

    @GetMapping(path = "/dispatchRecord/page")
    public R<PageResult<DispatchRecord>> getPage(
            @Validated GetDispatchTaskRecordPageReq req) {
        PageResult<DispatchRecord> result = dispatchTaskRecordService.getPage(req);
        return responseData(result);
    }

    @GetMapping(path = "/dispatchRecord/getByTaskId/{taskId}")
    public R<List<DispatchRecord>> getByTaskId(@PathVariable Integer taskId) {
        List<DispatchRecord> result = dispatchTaskRecordService.getByTaskId(taskId);
        return responseData(result);
    }
}
