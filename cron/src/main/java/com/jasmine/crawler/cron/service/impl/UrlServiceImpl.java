package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
    @Override
    public List<Url> getUrlToExecuteForSite(Integer siteId, Integer taskBatchCount) {
        Url url = new Url();
        List<Url> result = new LinkedList<>();
        result.add(url);
        return result;
    }
}
