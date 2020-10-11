package com.jasmine.crawler.web.admin.controller;

import com.jasmine.crawler.common.api.ControllerBase;
import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import com.jasmine.crawler.web.admin.pojo.vo.DownSystemSiteDispatchDetail;
import com.jasmine.crawler.web.admin.service.DownSystemSiteDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DownSystemDispatchController extends ControllerBase {

    @Autowired
    private DownSystemSiteDispatchService downSystemSiteDispatchService;

    @PostMapping(path = "/downSystemSiteDispatch")
    public  R add(@RequestBody DownSystemSiteDispatch req){
        boolean result =downSystemSiteDispatchService.add(req);
        return  responseBoolean(result);
    }

    @GetMapping(path = "/downSystemSiteDispatch/getBySourceDownSystemSiteId/{sourceDownSystemSiteId}")
    public R<List<DownSystemSiteDispatchDetail>> getBySourceDownSystemSiteId(@PathVariable Integer sourceDownSystemSiteId){
        List<DownSystemSiteDispatchDetail> result =downSystemSiteDispatchService.getBySourceDownSystemSiteId(sourceDownSystemSiteId);
        return  responseData(result);
    }

    @DeleteMapping(path = "/downSystemSiteDispatch/{id}")
    public  R delete(@PathVariable Integer id){
        boolean result = downSystemSiteDispatchService.delete(id);
        return  responseBoolean(result);
    }

}
