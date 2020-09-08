package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.cron.mapper.UrlMapper;
import com.jasmine.crawler.cron.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public List<Url> getUrlToExecuteForSite(Integer downSystemSiteId, Integer taskBatchCount) {
        R<List<Url>> result = restTemplate.getForObject(String.format("http://localhost:10042/url/getByDownSystemSiteId/%d", downSystemSiteId), R.class);
        return result.getData();
    }

    @Override
    public int resetUrlStatusToWaitByDownSystemSite(DownSystemSite downSystemSiteId) {
        return urlMapper.resetUrlStatusToWaitByDownSystemSite(downSystemSiteId);
    }
}
