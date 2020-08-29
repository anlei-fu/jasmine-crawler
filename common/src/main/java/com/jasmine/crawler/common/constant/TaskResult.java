package com.jasmine.crawler.common.constant;

/**
 * Enum of task result
 */
public final class TaskResult {

    /**
     * Means task finished and success
     */
    public static final Integer SUCCESS = 1;

    /**
     * Means task finished and failed (script exception, page download fail )
     */
    public static final Integer FAILED = 2;

    /**
     * Means task finished and blocked , but don't know the reason of block
     */
    public static final Integer BLOCKED = 3;

    /**
     * Means task finished cause ip was blocked
     */
    public static final Integer IP_BLOCKED = 4;

    /**
     * Means task finished cause account was blocked
     */
    public static final Integer ACCOUNT_BLOCKED = 5;

    /**
     * Means task failed cause bind timeout
     */
    public static final Integer BIND_TIMEOUT = 6;

    /**
     * Means task failed cause executing timeout
     */
    public static final Integer EXECUTE_TIMEOUT = 7;
}
