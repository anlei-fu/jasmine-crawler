package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;

public interface CrawlTaskService {
    boolean saveTaskResult(TaskResultReq req);

}
