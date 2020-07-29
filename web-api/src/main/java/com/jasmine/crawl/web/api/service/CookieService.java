package com.jasmine.crawl.web.api.service;

import com.jasmine.crawl.common.pojo.entity.Cookie;

public interface CookieService {
    Cookie getById(Integer cookieId);

    void decreaseCurrentRunningTaskCount(Integer id);

    void increaseBlockCount(Integer id);

    void resetBlockCount(Integer id);
}
