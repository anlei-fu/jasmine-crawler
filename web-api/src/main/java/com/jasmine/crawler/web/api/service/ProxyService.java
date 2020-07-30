package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Proxy;

public interface ProxyService {

    /**
     * Get proxy info
     *
     * @param proxyId
     * @return
     */
    Proxy get(Integer proxyId);

    /**
     * Decrease current use count
     *
     * @param proxyId
     */
    void decreaseCurrentUseCount(Integer proxyId);

    /**
     * Increase block count
     *
     * @param proxyId
     */
    void increaseBlockCount(Integer proxyId);

    /**
     * Reset block count
     *
     * @param proxyId
     */
    void resetBlockCount(Integer proxyId);
}
