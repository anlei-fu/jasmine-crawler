package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisableCookieJob extends LoggerSupport {

    @Autowired
    private CookieService cookieService;

    /**
     * To disable cookie that over max block count and set enable status 'false'
     */
    public void run() {
        List<Cookie> cookies=null;
        try {
            cookies= cookieService.getInvalidCookies();
            cookieService.disableInvalidCookies();
        } catch (Exception ex) {
            error(String.format("delete invalid cookie failed"), ex);
        }
    }

    public  void  disableCookieCore(Cookie cookie){

    }
}
