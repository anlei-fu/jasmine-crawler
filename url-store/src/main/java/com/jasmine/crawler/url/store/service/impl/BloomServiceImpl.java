package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import com.jasmine.crawler.url.store.service.BloomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class BloomServiceImpl implements BloomService {

    @Autowired
    private BloomMapper bloomMapper;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    @Override
    public boolean createNewBloom(Integer id) {
        if (bloomMapper.countById(id) > 0) {
            return false;
        }

        return bloomMapper.createById(id) > 0;
    }

    @Override
    public boolean disableById(Integer id) {
        return bloomMapper.disableById(id) > 0;
    }

    @Override
    public boolean filterUrl(String url) throws Exception {
        return false;
    }

}
