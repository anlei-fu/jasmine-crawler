package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawl.common.component.JasmineBloomFilter;
import com.jasmine.crawl.common.component.QueueManager;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawler.url.store.constant.UrlStatus;
import com.jasmine.crawler.url.store.mapper.SiteMapper;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import com.jasmine.crawler.url.store.pojo.entity.Site;
import com.jasmine.crawler.url.store.pojo.entity.Url;
import com.jasmine.crawler.url.store.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import com.jasmine.crawler.url.store.service.UrlService;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Service
public class UrlServiceImpl extends LoggerSupport implements UrlService  {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private SiteMapper siteMapper;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    @Autowired
    private QueueManager queueManager;

    @Override
    public String store() {
        return null;
    }

    @Override
    public boolean clearSite() {
        return false;
    }



    @Override
    public List<Url> getUrlForTask(GetUrlForTaskReq req) {
        RQueue<Url> queue = redissonClient.getQueue(String.format("url_q_%d", req.getDownSystemSiteId()));
        Site site = siteMapper.getById(req.getSiteId());
        List<Url> urls = new LinkedList<>();

        int size =queue.size();
        // load url from db to redis when cached url count less than task url count
        if (size < site.getTaskCount()) {
            info(String.format("load url from db,current cached url %d",size));
            List<Url> urlsToCache = urlMapper.getUrlToCacheByDownSiteId(
                    req.getDownSystemSiteId(),
                    site.getUrlMaxCacheCount()
            );

            queue.addAll(urlsToCache);
            info(String.format("load %d url tp cache,current cache size %d",urlsToCache.size(),queue.size()));
        }

        // poll url from redis
        int t = 0;
        while (t++ < queue.size()) {
            Url url = queue.poll();
            if (Objects.isNull(url))
                break;

            urls.add(url);
        }

        info(String.format("got %d url to run",urls.size()));

        return urls;
    }

    @Override
    public boolean saveUrlResult(SaveUrlResultReq req) {

        ConcurrentLinkedQueue queue =queueManager.getById(req.getDownSystemSiteId().toString());
        queue.add(req);
        List<Url> urls =new LinkedList<>();
        JasmineBloomFilter bloomFilter =bloomFilterManager.getBloomById(req.getDownSystemSiteId());
        for (int i=0; i<req.getNewUrls().size();i++){

            if(i%100==0){
                 saveNewUrl(urls);
                 urls =new LinkedList<>();
            }

            if(!bloomFilter.add(req.getNewUrls().get(i).getUrl()))
                continue;

            Url url =Url
                    .builder()
                    .url(req.getNewUrls().get(i).getUrl())
                    .referUrl(req.getNewUrls().get(i).getReferUrl())
                    .isDynamic(1)
                    .downSystemSiteId(req.getDownSystemSiteId())
                    .build();
            urls.add(url);
        }

        saveNewUrl(urls);

        updateUrlStatus(req.getSucceedUrls(),req.getDownSystemSiteId(), UrlStatus.SUCCESS);
        updateUrlStatus(req.getFailedUrls(),req.getDownSystemSiteId(),UrlStatus.FAILED);
        updateUrlStatus(req.getUrlNotToRun(),req.getDownSystemSiteId(),UrlStatus.FAILED_TO_RUN);
        updateUrlStatus(req.getFailedUrls(),req.getDownSystemSiteId(),UrlStatus.FAILED);
        return true;
    }

    private  void  saveNewUrl(List<Url> newUrls){

    }

    private  void  updateUrlStatus(List<String> url,Integer downSiteId,Integer urlStatus){

    }
}
