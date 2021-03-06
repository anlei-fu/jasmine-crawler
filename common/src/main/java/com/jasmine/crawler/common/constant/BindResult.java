package com.jasmine.crawler.common.constant;

/**
 * Enum of bind status
 */
public final class BindResult {
    /**
     * Means task bind success
     */
    public static final Integer SUCCESS = 1;

    /**
     * Means task bind failed cause site not available (removed or disabled)
     */
    public static final Integer SITE_NOT_AVAILABLE = 2;

    /**
     * Means task bind failed cause down system not available (removed or disabled)
     */
    public static final Integer DOWN_SYSTEM_NOT_AVAILABLE = 3;

    /**
     * Means task bind failed cause down site not available (removed or disabled)
     */
    public static final Integer DOWN_SYSTEM_SITE_NOT_AVAILABLE = 4;

    /**
     * Means task bind failed cause no cookie available fro task
     */
    public static final Integer NO_COOKIE_AVAILABLE = 5;

    /**
     * Means task bind failed cause no proxy available for task
     */
    public static final Integer NO_PROXY_AVAILABLE = 6;

    /**
     * Means task bind failed cause no crawler available for task
     */
    public static final Integer NO_CRAWLER_AVAILABLE = 7;

    /**
     * Means bind failed cause over down system site max concurrent running task count
     */
    public static final Integer OVER_DOWN_SYSTEM_SITE_MAX_CONCURRENCY = 8;

    /**
     * Means bind failed cause over down system max concurrent running task count
     */
    public static final Integer OVER_DOWN_SYSTEM_MAX_CONCURRENCY = 9;

    /**
     * Means bind failed cause exception happened when bind
     */
    public static final Integer EXCEPTION = 10;

}
