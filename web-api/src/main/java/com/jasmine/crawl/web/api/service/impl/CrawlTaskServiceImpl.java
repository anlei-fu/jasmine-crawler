package com.jasmine.crawl.web.api.service.impl;

import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;
import com.jasmine.crawl.web.api.service.CrawlTaskService;
import com.jasmine.crawl.web.api.service.DataService;
import com.jasmine.crawl.web.api.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class CrawlTaskServiceImpl  implements CrawlTaskService {

    @Autowired
    private UrlService urlService;

    @Autowired
    private DataService dataService;

    @Override
    public boolean saveTaskResult(TaskResultReq req) {
        return false;
    }


    private  void  terminateCrawTask(TaskResultReq req){

    }
}
