package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.BindRecord;
import com.jasmine.crawler.web.admin.service.BindRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@RestController
public class BindRecordController extends ControllerBase {

    @Autowired
    private BindRecordService bindRecordService;

    @GetMapping(path = "/bindRecord/getByTaskId/{taskId}")
    public R<List<BindRecord>> getByTaskId(@PathVariable Integer taskId) {
        List<BindRecord> result = bindRecordService.getByTaskId(taskId);
        return responseData(result);
    }
}
