package com.jasmine.crawler.web.api.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;
import com.jasmine.crawler.web.api.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrawlTaskController extends ControllerBase {

    @Autowired
    private CrawlTaskService crawlTaskService;

    @PostMapping(path = "/api/task/result/save")
    public R saveTaskResult(SaveTaskResultReq req) {
        boolean result = crawlTaskService.saveTaskResult(req);
        return responseBoolean(result);
    }
}
