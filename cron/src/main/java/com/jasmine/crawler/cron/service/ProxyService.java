/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.Proxy;

import java.util.List;

public interface ProxyService {

    /**
     * Get available proxy by site
     *
     * @param siteId
     * @return
     */
    Proxy getProxyBySite(Integer siteId);

    /**
     * Increase proxy current using count
     *
     * @param proxyId
     * @return
     */
    int increaseCurrentUseCount(Integer proxyId);

    /**
     * Get proxy info
     *
     * @param proxyId
     * @return
     */
    Proxy get(Integer proxyId);

    /**
     * Decrease proxy current using count
     *
     * @param proxyId
     */
    void decreaseCurrentUseCount(Integer proxyId);

    /**
     * Get expired proxies
     *
     * @return
     */
    List<Proxy> getExpiredProxies();

    /**
     * Delete proxies batch
     *
     * @param proxyIds
     */
    void disableProxiesBatch(List<Integer> proxyIds);

    /**
     * Get proxies which is enable status is false and disable timeout
     *
     * @return
     */
    List<Proxy> getDisableTimeoutProxies();

    /**
     * Enable proxies batch
     *
     * @param proxyIds
     */
    void enableProxiesBatch(List<Integer> proxyIds);
}
