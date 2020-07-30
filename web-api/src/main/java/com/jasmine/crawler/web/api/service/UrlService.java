package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.web.api.pojo.req.SaveUrlResultReq;

public interface UrlService {

    /**
     * Save task url result
     *
     * @param saveUrlResultReq
     */
    void saveUrlResult(SaveUrlResultReq saveUrlResultReq);
}