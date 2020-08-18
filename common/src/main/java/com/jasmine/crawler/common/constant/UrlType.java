package com.jasmine.crawler.common.constant;

/**
 * Enum of url type
 */
public final class UrlType {
    /**
     * Means url just crawl once
     */
    public static final Integer ONCE = 1;

    /**
     * Means url can crawl many times
     */
    public static final Integer DYNAMIC = 2;

    /**
     * Means url is a seed
     */
    public static final Integer SEED = 3;

    /**
     * Means url is a api
     */
    public  static  final  Integer API =4;
}
