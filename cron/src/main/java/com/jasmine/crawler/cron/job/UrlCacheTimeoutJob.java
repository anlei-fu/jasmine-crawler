package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class UrlCacheTimeoutJob {

    @Autowired
    private UrlService urlService;

    public  void  run(){

    }
}