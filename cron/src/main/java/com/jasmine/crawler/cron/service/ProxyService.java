/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

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
     * Get available proxy by site
     *
     * @param siteId
     * @return
     */
    Proxy getProxyForSite(Integer siteId);

    /**
     * Increase proxy current using count
     *
     * @param proxyId
     * @return
     */
    int increaseCurrentUseCount(Integer proxyId);

    /**
     * Decrease proxy current using count
     *
     * @param proxyId
     */
    void decreaseCurrentUseCount(Integer proxyId);

    /**
     * Disable proxies batch
     */
    void disableBlockedProxies();
}
