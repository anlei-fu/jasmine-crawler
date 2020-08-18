package com.jasmine.crawler.common.constant;

/**
 * Enum of crawl type
 */
public final class CrawlType {
    /**
     * Static page,use cheerio to resolve
     */
    private static final Integer STATIC_PAGE = 1;

    /**
     * Dynamic page ,use browser to resolve
     */
    private static final Integer BROWSER_PAGE = 2;

    /**
     * Call api
     */
    public  static  final  Integer API=3;
}
