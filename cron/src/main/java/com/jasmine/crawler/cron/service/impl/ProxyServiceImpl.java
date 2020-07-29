/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawl.common.pojo.entity.Proxy;
import com.jasmine.crawler.cron.mapper.ProxyMapper;
import com.jasmine.crawler.cron.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyMapper proxyMapper;

    @Override
    public Proxy getProxyForSite(Integer siteId) {
        return proxyMapper.getProxyBySiteId(siteId);
    }

    @Override
    public int increaseCurrentUseCount(Integer proxyId) {
        return proxyMapper.increaseCurrentUseCountById(proxyId);
    }

    @Override
    public Proxy get(Integer id) {
        return proxyMapper.getById(id);
    }

    @Override
    public void decreaseCurrentUseCount(Integer id) {
        proxyMapper.decreaseCurrentUseCountById(id);
    }

    @Override
    public List<Proxy> getExpiredProxies() {
        return proxyMapper.getExpiredProxies();
    }

    @Override
    public void disableProxiesBatch(List<Integer> proxyIds) {
        proxyMapper.disableProxiesBatch(proxyIds);
    }

    @Override
    public List<Proxy> getDisableTimeoutProxies() {
        return proxyMapper.getDisableTimeoutProxies();
    }

    @Override
    public void enableProxiesBatch(List<Integer> proxyIds) {
        proxyMapper.enableProxiesBatch(proxyIds);
    }

}

