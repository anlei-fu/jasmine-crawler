package com.jasmine.crawler.web.api.service.impl;

import com.jasmine.crawler.common.pojo.entity.Site;
import com.jasmine.crawler.web.api.mapper.SiteMapper;
import com.jasmine.crawler.web.api.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteMapper siteMapper;

    @Override
    public Site get(Integer id) {
        return siteMapper.getById(id);
    }

}
