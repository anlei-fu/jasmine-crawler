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
     * Means task finished and blocked
     */
    public static final Integer BLOCKED = 2;

    /**
     * Means task failed and bind timeout
     */
    public static final Integer BIND_TIMEOUT = 3;

    /**
     * Means task execute  timeout
     */
    public static final Integer EXECUTE_TIMEOUT = 4;
}
