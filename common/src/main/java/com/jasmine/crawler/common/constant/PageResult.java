package com.jasmine.crawler.common.constant;

public final class PageResult {

    /**
     * Means page is ok and data extracted
     */
    public static final Integer SUCCESS = 1;

    /**
     * Means the crawl script has not set page result
     */
    public static final Integer UNSET = 2;

    /**
     * Means failed cause download page failed
     */
    public static final Integer DOWNLOAD_FAILED = 3;

    /**
     * Means can not found target page
     */
    public static final Integer PAGE_NOT_EXIST = 4;

    /**
     * Means target page is not excepted page
     */
    public static final Integer PAGE_INCORRECT = 5;

    /**
     * Means script execution failed
     */
    public static final Integer SCRIPT_INCORRECT = 6;

    /**
     * Means task has been blocked by site
     */
    public static final Integer BLOCKED = 7;

    /**
     * Means page is not crawled
     */
    public static final Integer FAILED_TO_RUN = 8;

    /**
     * Means target page is a bad page
     */
    public static final Integer BAD = 9;

}
