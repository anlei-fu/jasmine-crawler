package com.jasmine.crawler.common.constant;

/**
 * Enum of dispatch status
 */
public final class DispatchResult {
    /**
     * Means wait to dispatch
     */
    public static final Integer WAIT = 0;

    /**
     * Means dispatch failed, cause site not available
     */
    public static final Integer SITE_NOT_AVAILABLE = 1;

    /**
     * Means dispatch failed, cause down site not available
     */
    public static final Integer DOWN_SITE_NOT_AVAILABLE = 1;

    /**
     * Means dispatch failed, cause down system not available
     */
    public static final Integer DOWN_SYSTEM_NOT_AVAILABLE = 2;

    /**
     * Means dispatch failed, cause  crawler not available
     */
    public static final Integer CRAWLER_NOT_AVAILABLE = 3;

    /**
     * Means dispatch failed, cause  proxy not available
     */
    public static final Integer PROXY_NOT_AVAILABLE = 4;

    /**
     * Means dispatch failed, cause  cookie not available
     */
    public static final Integer COOKIE_NOT_AVAILABLE = 5;

    /**
     * Means dispatch failed, cause  can not get url to run
     */
    public static final Integer GET_URL_TO_RUN_FAILED = 6;

    /**
     * Means dispatch failed, cause post  crawler failed ,maybe crawler has down
     */
    public static final Integer POST_CRAWLER_FAILED = 7;

    /**
     * Means dispatch success
     */
    public static final Integer SUCCESS = 8;

    /**
     * Means dispatch failed ,exception happened when dispatch
     */
    public static final Integer EXCEPTION = 9;
}
