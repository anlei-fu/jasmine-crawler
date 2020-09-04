package com.jasmine.crawler.common.constant;

public final class PageResult {

    /**
     * Means page is ok and data extracted
     */
    public static final Integer SUCCESS = 1;

    public static final Integer UNSET = 2;
    /**
     * Means failed cause unable to download page
     */
    public static final Integer DOWNLOAD_FAILED = 3;

    public static final Integer PAGE_NOT_EXIST = 4;

    public static final Integer PAGE_INCORRECT = 5;
    /**
     * Means script exception
     */
    public static final Integer SCRIPT_INCORRECT = 6;

    /**
     * Means script exception
     */
    public static final Integer BLOCKED = 7;
    /**
     * Means page is not crawled
     */
    public static final Integer FAILED_TO_RUN = 8;

    /**
     * Means script exception
     */
    public static final Integer BAD = 9;

}
