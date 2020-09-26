package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.entity.Cookie;

public interface CookieService {

    /**
     * Get cookie info
     *
     * @param cookieId
     * @return
     */
    Cookie get(Integer cookieId);

    /**
     * Decrease current running task count
     *
     * @param cookieId
     */
    void decreaseCurrentUseCount(Integer cookieId);

    /**
     * Increase current running task count
     *
     * @param cookieId
     */
    void increaseBlockCount(Integer cookieId);

    /**
     * Reset block count
     *
     * @param cookieId
     */
    void resetBlockCount(Integer cookieId);

    /**
     * Set cookie status to disabled
     *
     * @param id
     */
    void disable(Integer id);
}
