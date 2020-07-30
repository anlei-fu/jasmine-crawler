package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.web.api.mapper.ProxyMapper;
import com.jasmine.crawler.web.api.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProxyServiceImpl implements ProxyService {

    @Autowired
    private ProxyMapper proxyMapper;

    @Override
    public Proxy get(Integer proxyId) {
        return proxyMapper.getById(proxyId);
    }

    @Override
    public void decreaseCurrentUseCount(Integer id) {
        proxyMapper.decreaseCurrentUseCount(id);
    }

    @Override
    public void increaseBlockCount(Integer id) {
        proxyMapper.increaseBlockCount(id);
    }

    @Override
    public void resetBlockCount(Integer id) {
        proxyMapper.resetBlockCount(id);
    }
}
