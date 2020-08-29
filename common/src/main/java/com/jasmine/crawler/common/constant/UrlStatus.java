package com.jasmine.crawler.common.constant;

/**
 * Enum of url status
 */
public final class UrlStatus {
    /**
     * Means url wait to run
     */
    public static final Integer WAIT = 1;

    /**
     * Means url cached to redis and wait to crawl
     */
    public static final Integer CACHED = 2;

    /**
     * Means url finished
     */
    public static final Integer FINISHED = 3;
}
