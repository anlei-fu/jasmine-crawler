package com.jasmine.crawl.web.api.controller;

import com.jasmine.crawl.common.api.ControllerBase;
import com.jasmine.crawl.common.api.resp.R;
import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;
import com.jasmine.crawl.web.api.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@RestController
public class CrawlTaskController extends ControllerBase {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @PostMapping(path = "/api/task/save")
    public R saveTaskResult(TaskResultReq req){
        boolean result =crawlTaskService.saveTaskResult(req);
        return  responseBoolean(result);
    }
}
