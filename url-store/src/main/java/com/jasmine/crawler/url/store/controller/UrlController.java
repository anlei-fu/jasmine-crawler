package com.jasmine.crawler.url.store.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UrlController extends ControllerBase {

    @Autowired
    private UrlService urlService;

    @GetMapping(path = "/url/getByDownSystemSiteId/{downSystemSiteId}")
    public R<List<Url>> getUrlForTask(@PathVariable Integer downSystemSiteId) throws Exception {
        List<Url> result = urlService.getUrlForSite(downSystemSiteId);
        return responseData(result);
    }

    @PostMapping(path = "/url/save/")
    public R saveUrlResult(SaveUrlResultReq req) {
        boolean result = urlService.saveTaskUrlResult(req);
        return responseBoolean(result);
    }

}
