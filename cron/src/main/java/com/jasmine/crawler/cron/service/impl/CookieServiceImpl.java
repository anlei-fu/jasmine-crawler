/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.CookieMapper;
import com.jasmine.crawl.common.pojo.entity.Cookie;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    private CookieMapper cookieMapper;

    @Override
    public Cookie getById(Integer id) {
        return cookieMapper.getById(id);
    }

    @Override
    public Cookie getBySiteId(Integer id) {
        return cookieMapper.getBySiteId();
    }

    @Override
    public void increaseCurrentUseCountById(Integer id) {
            cookieMapper.increaseCurrentUseCountById(id);
    }

    @Override
    public List<Cookie> getExpiredCookies() {
        return cookieMapper.getExpiredCookies();
    }

    @Override
    public void deleteCookieBatch(List<Integer> cookieIds) {
              cookieMapper.deleteCookieBatch(cookieIds);
    }

    @Override
    public void decreaseCurrentUseCountById(Integer id) {
        cookieMapper.decreaseCurrentUseCountById(id);
    }

}

