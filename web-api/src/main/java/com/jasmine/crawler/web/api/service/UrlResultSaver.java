package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;

public interface UrlResultSaver {
    /**
     * Save task url result
     *
     * @param saveUrlResultReq
     */
    void saveUrlResult(SaveUrlResultReq saveUrlResultReq);
}
