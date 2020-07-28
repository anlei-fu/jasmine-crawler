package com.jasmine.crawler.url.store.controller;

import com.jasmine.crawl.common.api.ControllerBase;
import com.jasmine.crawl.common.api.resp.R;
import com.jasmine.crawler.url.store.pojo.entity.Url;
import com.jasmine.crawler.url.store.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@RestController
public class UrlController extends ControllerBase {
    @Autowired
    private UrlService urlService;

    @GetMapping(path = "/url/get/for/task")
    public R<List<Url>> getUrlForTask(GetUrlForTaskReq req){
        List<Url> result =urlService.getUrlForTask(req);
        return  responseData(result);
    }

    @PostMapping(path = "/url/save/result")
    public  R saveUrlResult(SaveUrlResultReq req){
        boolean result =urlService.saveUrlResult(req);
        return  responseBoolean(result);
    }

}
