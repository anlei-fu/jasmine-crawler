/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawl.common.pojo.entity.Cookie;

import java.util.List;

/**
 * Manage cookie
 */
public interface CookieService {

    /**
     * Get cookie info
     *
     * @param cookieId
     * @return
     */
    Cookie get(Integer cookieId);

    /**
     * Get an available cookie for site
     *
     * @param siteId
     * @return
     */
    Cookie getCookieForSite(Integer siteId);

    /**
     * Increase current cookie using count
     *
     * @param cookieId
     */
    void increaseCurrentUseCount(Integer cookieId);

    /**
     * Get expired cookies which timeouted or blocked by site
     *
     * @return
     */
    List<Cookie> getExpiredCookies();

    /**
     * Delete cookie batch
     *
     * @param cookieIds
     */
    void deleteBatch(List<Integer> cookieIds);

    /**
     * Increase  cookie current using count
     *
     * @param cookieId
     */
    void decreaseCurrentUseCount(Integer cookieId);
}
