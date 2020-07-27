package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.cron.service.SiteUrlBloomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class SiteUrlBloomJob {

    @Autowired
    private SiteUrlBloomService siteUrlBloomService;

    public void run() {

    }
}
