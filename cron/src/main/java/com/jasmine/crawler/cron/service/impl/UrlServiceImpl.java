package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.api.resp.R;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.cron.mapper.UrlMapper;
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

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public List<Url> getUrlToExecuteForSite(Integer downSystemSiteId, Integer taskUrlBatchCount) {
        try {
            R<List<Url>> result = restTemplate.getForObject(String.format("http://localhost:10042/url/getByDownSystemSiteId/%d", downSystemSiteId), R.class);
            return result.getData();
        } catch (Exception ex) {
            return new LinkedList<>();
        }
    }

    @Override
    public int resetCachedUrlToWaitByDownSystemSite(DownSystemSite downSystemSiteId) {
        return urlMapper.resetCacheUlrToWaitByDownSystemSite(downSystemSiteId);
    }

    @Override
    public int resetFailedUrlToWaitByDownSystemSite(DownSystemSite downSystemSite) {
        return urlMapper.resetFailedUrlToWaitByDownSystemSite(downSystemSite);
    }

    @Override
    public int resetSuccessUrlToWaitByDownSystemSite(DownSystemSite downSystemSite) {
        return urlMapper.resetSucceedUrlToWaitByDownSystemSite(downSystemSite);
    }
}
