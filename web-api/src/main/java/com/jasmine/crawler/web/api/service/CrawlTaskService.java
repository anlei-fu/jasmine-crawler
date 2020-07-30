package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.web.api.pojo.req.TaskResultReq;

public interface CrawlTaskService {

    /**
     * Save task execute result
     *
     * @param req
     * @return
     */
    boolean saveTaskResult(TaskResultReq req);
}
