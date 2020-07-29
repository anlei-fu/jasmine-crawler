package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.Proxy;

public interface ProxyService {
    Proxy getById(Integer proxyId);

    void decreaseCurrentUseCount(Integer id);

    void increaseBlockCount(Integer id);

    void resetBlockCount(Integer id);
}
