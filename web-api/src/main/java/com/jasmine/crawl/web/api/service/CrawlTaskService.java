package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.web.api.pojo.req.TaskResultReq;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface CrawlTaskService {
    boolean saveTaskResult(TaskResultReq req);

}
