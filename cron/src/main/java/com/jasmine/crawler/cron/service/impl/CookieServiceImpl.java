/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.cron.mapper.CookieMapper;
import com.jasmine.crawler.cron.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    private CookieMapper cookieMapper;

    @Override
    public Cookie get(Integer id) {
        return cookieMapper.get(id);
    }

    @Override
    public Cookie getCookieForSite(Integer siteId) {
        return cookieMapper.getBySiteId(siteId);
    }

    @Override
    public void increaseCurrentUseCount(Integer id) {
        cookieMapper.increaseCurrentUseCountById(id);
    }

    @Override
    public void decreaseCurrentUseCount(Integer id) {
        cookieMapper.decreaseCurrentUseCountById(id);
    }

    @Override
    public void removeExpiredCookies() {
         cookieMapper.removeExpiredCookies();
    }

}

