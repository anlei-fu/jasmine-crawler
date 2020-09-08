package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.web.api.mapper.UrlMapper;
import com.jasmine.crawler.web.api.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UrlServiceImpl extends LoggerSupport implements UrlService {

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public Integer resetUrls(List<Integer> ids) {
        return urlMapper.resetUrls(ids);
    }

    @Override
    public Integer resetSeedUrl(Integer downSystemSiteId) {
        return urlMapper.resetSeedUrl(downSystemSiteId);
    }
}
