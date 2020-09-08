package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;

public interface UrlResultFetcher {
    SaveUrlResultReq fetch();
}
