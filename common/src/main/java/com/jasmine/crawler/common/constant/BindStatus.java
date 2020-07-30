package com.jasmine.crawler.common.constant;

/**
 * Enum of bind status
 */
public final class BindStatus {
    /**
     * Means task wait to bind
     */
    public static final Integer WAIT = 1;

    /**
     * Means task bind failed cause site not available (removed or disabled)
     */
    public static final Integer SITE_NOT_AVAILABLE = 2;

    /**
     * Means task bind failed cause down site not available (removed or disabled)
     */
    public static final Integer DOWN_SYSTEM_SITE_NOT_AVAILABLE = 3;

    /**
     * Means task bind failed cause down system not available (removed or disabled)
     */
    public static final Integer DOWN_SYSTEM_NOT_AVAILABLE = 4;

    /**
     * Means task bind failed cause no proxy available
     */
    public static final Integer NO_PROXY_AVAILABLE = 5;

    /**
     * Means task bind failed cause no cookie available
     */
    public static final Integer NO_COOKIE_AVAILABLE = 6;

    /**
     * Means bind success
     */
    public static final Integer SUCCESS = 7;

    /**
     * Means bind failed cause exception happened when bind
     */
    public static final Integer EXCEPTION = 8;
}
