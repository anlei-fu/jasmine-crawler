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
     * Get crawler info
     *
     * @param id
     * @return
     */
    Crawler get(int id);

    /**
     * Get an available crawlers for site
     *
     * @param siteId
     * @param taskUrlMaxConcurrency
     * @param useCrawlerIp
     * @return
     */
    List<Crawler> getCrawlerForSite(Integer siteId, Integer taskUrlMaxConcurrency, boolean useCrawlerIp);

    /**
     * Change crawler current concurrency
     *
     * @param crawlerId
     * @param concurrencyToChange
     */
    void changeCurrentConcurrency(Integer crawlerId, Integer concurrencyToChange);

    /**
     * Get crawlers which need to do heartbeat check,the {@Field Crawler.heartbeatLostCount} smaller
     * the heartbeat check more often ,max interval is 5 minute
     *
     * @return
     */
    List<Crawler> getNeedHeartbeatCrawlers();

    /**
     * Update crawler heartbeat status
     *
     * @param crawlerId
     * @param up
     */
    void updateHeartbeatStatus(Integer crawlerId, boolean up);

}
