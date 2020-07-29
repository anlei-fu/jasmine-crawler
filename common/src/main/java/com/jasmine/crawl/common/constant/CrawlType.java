package com.jasmine.crawl.common.constant;

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
    private static final Integer DYNAMIC_PAGE = 2;
}
