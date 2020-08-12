/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.Cookie;

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
     * Increase  cookie current using count
     *
     * @param cookieId
     */
    void decreaseCurrentUseCount(Integer cookieId);

    /**
     * Get expired cookies which timeouted or blocked by site
     */
    void disableInvalidCookies();

    void updateDelayTimeout(Integer id);

    List<Cookie> getInvalidCookies();
}
