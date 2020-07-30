package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.web.api.mapper.DownSystemSiteMapper;
import com.jasmine.crawler.web.api.service.DownSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownSystemSiteServiceImpl implements DownSystemService {

    @Autowired
    private DownSystemSiteMapper downSystemSiteMapper;

    @Override
    public void decreaseCurrentRunningTaskCount(Integer id) {
        downSystemSiteMapper.decreaseCurrentRunningTaskCount(id);
    }
}
