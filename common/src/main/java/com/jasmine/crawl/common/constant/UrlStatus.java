package com.jasmine.crawl.common.constant;

/**
 * Enum of url status
 */
public final class UrlStatus {
    /**
     * Means url crawl successfully
     */
    public static final Integer SUCCESS = 1;

    /**
     * Means url crawl failed
     */
    public static final Integer FAILED = 2;

    /**
     * Means url is a bad url (not available or fake url)
     */
    public static final Integer BAD = 3;

    /**
     * Means task failed and url has not been crawled
     */
    public static final Integer FAILED_TO_CRAWL = 4;

}
