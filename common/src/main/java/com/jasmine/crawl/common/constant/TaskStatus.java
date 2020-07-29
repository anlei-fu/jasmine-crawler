package com.jasmine.crawl.common.constant;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public final class TaskStatus {
    /**
     * Means task wait to execute
     */
    public static final Integer WAIT = 0;

    /**
     * Means task is executing
     */
    public static final Integer EXECUTING = 1;

    /**
     * Means task executed successfully
     */
    public static final Integer SUCCESS = 2;

    /**
     * Means task execute failed , cause network failed ,maybe proxy problem or local network error
     */
    public static final Integer NETWORK_FAILED = 3;

    /**
     * Means task execute failed ,cause exceeding max task timeout
     */
    public static final Integer TIMEOUT = 4;

    /**
     * Means task execute failed ,cause ip or cookie has been seam as a crawler by site
     */
    public static final Integer BLOCKED = 5;

}
