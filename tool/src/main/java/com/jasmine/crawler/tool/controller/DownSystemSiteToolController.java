package com.jasmine.crawler.tool.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.tool.service.DownSystemSiteTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownSystemSiteToolController extends ControllerBase {

    @Autowired
    private DownSystemSiteTool downSystemSiteTool;

    @GetMapping("/downSystemSiteTool/balance")
    public R balance(Integer downSystemSiteId,Integer maxDays,Integer maxHours){
        downSystemSiteTool.createLimit(downSystemSiteId, maxDays, maxHours);
        downSystemSiteTool.balanceRunLimit(downSystemSiteId);
        return  success();
    }

    @GetMapping("/downSystemSiteTool/resetConcurrency/{downSystemSiteId}")
    public  R resetConcurrency(@PathVariable Integer downSystemSiteId){
        downSystemSiteTool.resetConcurrency(downSystemSiteId);
        return success();
    }
}
