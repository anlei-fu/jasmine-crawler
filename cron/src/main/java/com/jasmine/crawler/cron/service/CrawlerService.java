/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.Crawler;

import java.util.List;

/**
 * Manage crawler
 */
public interface CrawlerService {

    /**
     * Get crawler info by crawlerId
     *
     * @param crawlerId
     * @return
     */
    Crawler get(int crawlerId);

    /**
     * Get an available crawler for site
     *
     * @param siteId
     * @param withIp
     * @return
     */
    Crawler getCrawlerForSite(Integer siteId, boolean withIp);

    /**
     * Increase crawler current concurrency
     *
     * @param crawlerId
     * @param concurrencyToIncrease
     */
    void increaseCurrentConcurrency(Integer crawlerId, Integer concurrencyToIncrease);

    /**
     * Get crawlers which need to do heartbeat check,the {@Field Crawler.heartbeatLostCount} smaller
     * the heartbeat check more often ,max interval is 5 minute
     *
     * @return
     */
    List<Crawler> getCrawlersNeedHeartbeat();

    /**
     * Update crawler heartbeat status
     *
     * @param crawlerId
     * @param heartbeatStatus
     */
    void updateHeartbeatStatus(Integer crawlerId, Integer heartbeatStatus);

}
