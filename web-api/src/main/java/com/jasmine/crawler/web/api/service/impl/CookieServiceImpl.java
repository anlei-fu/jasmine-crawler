package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.Cookie;
import com.jasmine.crawler.web.api.mapper.CookieMapper;
import com.jasmine.crawler.web.api.service.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    private CookieMapper cookieMapper;

    @Override
    public Cookie get(Integer id) {
        return cookieMapper.getById(id);
    }

    @Override
    public void decreaseCurrentUseCount(Integer id) {
        cookieMapper.decreaseCurrentUseCount(id);
    }

    @Override
    public void increaseBlockCount(Integer id) {
        cookieMapper.increaseBlockCount(id);
    }

    @Override
    public void resetBlockCount(Integer id) {
        cookieMapper.resetBlockCount(id);
    }

    @Override
    public void disable(Integer id) {
        cookieMapper.disable(id);
    }
}
