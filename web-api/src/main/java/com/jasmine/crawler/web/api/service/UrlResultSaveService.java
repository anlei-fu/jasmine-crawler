package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;

public interface UrlResultSaveService {
    /**
     * Save task url result
     *
     * @param saveUrlResultReq
     */
    void saveUrlResult(SaveUrlResultReq saveUrlResultReq);
}
