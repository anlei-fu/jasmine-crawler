package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.web.admin.service.DownSystemSiteRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DownSystemSiteRunLimitController extends ControllerBase {

    @Autowired
    private DownSystemSiteRunLimitService downSystemSiteRunLimitService;

    @GetMapping(path = "/downSystemSiteRunLimit/{downSystemSiteId}")
    public R<List<DownSystemSiteRunLimit>> getByDownSystemSiteId(@PathVariable Integer downSystemSiteId) {
        List<DownSystemSiteRunLimit> result = downSystemSiteRunLimitService.getByDownSystemSiteId(downSystemSiteId);
        return responseData(result);
    }

    @PutMapping(path = "/downSystemSiteRunLimit/disable/{id}")
    public R disable(@PathVariable Integer id) {
        boolean result = downSystemSiteRunLimitService.disable(id);
        return responseBoolean(result);
    }

    @PutMapping(path = "/downSystemSiteRunLimit/enable/{id}")
    public R enable(@PathVariable Integer id) {
        boolean result = downSystemSiteRunLimitService.enable(id);
        return responseBoolean(result);
    }
}
