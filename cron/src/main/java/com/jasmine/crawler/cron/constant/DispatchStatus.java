package com.jasmine.crawler.cron.constant;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public final class DispatchStatus {
    public static final Integer WAIT = 0;
    public static final Integer SITE_NOT_AVAILABLE = 0;

    public static final Integer DOWN_SITE_NOT_AVAILABLE = 1;
    public static final Integer DOWN_SYSTEM_NOT_AVAILABLE = 1;

    public static final Integer CRAWLER_NOT_AVAILABLE = 0;
    public static final Integer PROXY_NOT_AVAILABLE = 0;
    public static final Integer COOKIE_NOT_AVAILABLE = 0;

    public static final Integer GET_URL_TO_RUN_FAILED = 9;

    public static final Integer POST_CRAWLER_FAILED = 10;

    public static final Integer SUCCESS = 0;
    public static final Integer FAILED = 0;
}
