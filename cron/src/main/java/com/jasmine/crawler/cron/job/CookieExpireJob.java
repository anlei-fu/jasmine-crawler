package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.pojo.entity.Cookie;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class CookieExpireJob extends LoggerSupport {

    @Autowired
    private CookieService cookieService;

    public void run() {
        try {
            List<Cookie> cookies = cookieService.getExpiredCookies();
            List<Integer> cookieIds = getCookieIds(cookies);
            cookieService.deleteCookieBatch(cookieIds);
            info(String.format("delete cookies %s", null));
        } catch (Exception ex) {
            error(String.format("delete invalid cookie failed"), ex);
        }
    }

    private List<Integer> getCookieIds(List<Cookie> cookies) {
        return null;
    }
}
