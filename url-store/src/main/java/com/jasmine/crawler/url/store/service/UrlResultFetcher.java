package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;

public interface UrlResultFetcher {

    /**
     * To fetch url result
     *
     * @return
     */
    SaveUrlResultReq fetch();
}
