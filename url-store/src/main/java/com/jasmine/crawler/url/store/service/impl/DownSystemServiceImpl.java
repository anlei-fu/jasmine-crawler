package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.mapper.DownSystemMapper;
import com.jasmine.crawler.url.store.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class DownSystemServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Override
    public void increaseNewUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseNewUrlCount(downSystemId, size);
    }

    @Override
    public void increaseBadUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseBadUrlCount(downSystemId, size);
    }

    @Override
    public void increaseFinishedUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseFinishedUrlCount(downSystemId, size);
    }
}
