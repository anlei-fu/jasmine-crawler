package com.jasmine.crawler.common.constant;

public final class PageResult {

    /**
     * Means page is ok and data extracted
     */
    public static final Integer SUCCESS = 1;

    /**
     * Means page is bad (404 or else)
     */
    public static final Integer BAD = 2;

    /**
     * Means page is not crawled
     */
    public static final Integer FAILED_TO_RUN = 3;

    /**
     * Means script exception
     */
    public static final Integer SCRIPT_EXCEPTION = 4;

    /**
     * Means failed cause unable to download page
     */
    public static final Integer DOWNLOAD_FAILED = 5;

    /**
     * Means page result is not set by 'main' script
     */
    public static final Integer UNSET = 6;

    /**
     * Means page is not correct
     */
    public static final Integer PAGE_INCORRECT = 7;
}
