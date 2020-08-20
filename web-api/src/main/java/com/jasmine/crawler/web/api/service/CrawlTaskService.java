package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.req.SaveTaskResultReq;

public interface CrawlTaskService {

    /**
     * Save task execute result
     *
     * @param req
     * @return
     */
    boolean saveTaskResult(SaveTaskResultReq req);
}
