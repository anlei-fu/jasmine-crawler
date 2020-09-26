package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteRunLimit;
import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemRunLimitReq;
import com.jasmine.crawler.web.admin.service.DownSystemSiteRunLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping(path="/downSystemSiteRunLimit/update")
    public  R update(@RequestBody UpdateDownSystemRunLimitReq req){
        boolean result =downSystemSiteRunLimitService.update(req);
        return  responseBoolean(result);
    }
}
