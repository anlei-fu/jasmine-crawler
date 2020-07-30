package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;

public class CookieExpireJob extends LoggerSupport {

    @Autowired
    private CookieService cookieService;

    public void run() {
        try {
           cookieService.removeExpiredCookies();
        } catch (Exception ex) {
            error(String.format("delete invalid cookie failed"), ex);
        }
    }
}
