package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.SiteAccountRunLimit;
import com.jasmine.crawler.web.admin.service.SiteAccountRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiteAccountRunLimitController extends ControllerBase {

    @Autowired
    private SiteAccountRunLimitService siteAccountRunLimitService;

    @GetMapping(path = "/siteAccountRunLimit/{downSystemSiteId}")
    public R<List<SiteAccountRunLimit>> getByDownSystemSiteId(@PathVariable Integer downSystemSiteId){
        List<SiteAccountRunLimit> result =siteAccountRunLimitService.getByDownSystemSiteId(downSystemSiteId);
        return  responseData(result);
    }

    @PutMapping(path = "/siteAccountRunLimit/disable/{id}")
    public R disable(@PathVariable Integer id){
        boolean result = siteAccountRunLimitService.disable(id);
        return  responseBoolean(result);
    }

    @PutMapping(path = "/siteAccountRunLimit/enable/{id}")
    public R enable(@PathVariable Integer id){
        boolean result = siteAccountRunLimitService.enable(id);
        return  responseBoolean(result);
    }
}
