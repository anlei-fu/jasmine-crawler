package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Url> getUrlToExecuteForSite(Integer siteId, Integer taskBatchCount) {
        R<List<Url>> result = restTemplate.getForObject(String.format("http://localhost:10042/url/getByDownSystemSiteId/%d",siteId),R.class);
        return  result.getData();
    }
}
