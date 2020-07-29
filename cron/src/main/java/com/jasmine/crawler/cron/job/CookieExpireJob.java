package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.pojo.entity.Cookie;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class CookieExpireJob extends LoggerSupport {

    @Autowired
    private CookieService cookieService;

    public void run() {
        try {
            List<Cookie> cookies = cookieService.getExpiredCookies();
            List<Integer> cookieIds = getCookieIds(cookies);
            cookieService.deleteBatch(cookieIds);
            info(String.format("delete cookies %s", null));
        } catch (Exception ex) {
            error(String.format("delete invalid cookie failed"), ex);
        }
    }

    private List<Integer> getCookieIds(List<Cookie> cookies) {
        List<Integer> ls = new LinkedList<>();
        cookies.stream().forEach(cookie -> {
            ls.add(cookie.getId());
        });
        return ls;
    }
}
