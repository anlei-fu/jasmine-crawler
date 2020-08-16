package com.jasmine.crawler.common.constant;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public final class TaskStatus {
    /**
     * Means task wait to bind
     */
    public static final Integer WAIT_TO_BIND = 0;

    /**
     * Means task wait to dispatch
     */
    public static final Integer WAIT_TO_DISPATCH = 1;

    /**
     * Means task is executing
     */
    public static final Integer EXECUTING = 2;

    /**
     * Means task finished
     */
    public static final Integer FINISHED = 3;

}
