package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.url.store.mapper.DownSystemMapper;
import com.jasmine.crawler.url.store.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Override
    public void addNewUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseNewUrlCount(downSystemId, size);
    }

    @Override
    public void addBadUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseBadUrlCount(downSystemId, size);
    }

    @Override
    public void addFinishedUrlCount(Integer downSystemId, int size) {
        downSystemMapper.increaseFinishedUrlCount(downSystemId, size);
    }
}
