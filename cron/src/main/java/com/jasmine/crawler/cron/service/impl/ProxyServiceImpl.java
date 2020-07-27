/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.ProxyMapper;
import com.jasmine.crawler.cron.pojo.entity.Proxy;
import com.jasmine.crawler.cron.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyMapper proxyMapper;

    @Override
    public Proxy getProxyBySiteId(Integer siteId) {
        return proxyMapper.getProxyBySiteId(siteId);
    }

    @Override
    public int increaseCurrentUseCountById(Integer id) {
        return proxyMapper.increaseCurrentUseCountById(id);
    }

    @Override
    public Proxy getById(Integer id) {
        return proxyMapper.getById(id);
    }

    @Override
    public void decreaseCurrentUseCountById(Integer id) {
            proxyMapper.decreaseCurrentUseCountById(id);
    }

}

