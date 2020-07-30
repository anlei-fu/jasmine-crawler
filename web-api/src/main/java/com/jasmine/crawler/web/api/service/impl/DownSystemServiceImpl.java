package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.web.api.mapper.DownSystemMapper;
import com.jasmine.crawler.web.api.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemMapper downSystemMapper;

    @Override
    public void decreaseCurrentRunningTaskCount(Integer id) {
        downSystemMapper.decreaseCurrentRunningTaskCount(id);
    }
}
