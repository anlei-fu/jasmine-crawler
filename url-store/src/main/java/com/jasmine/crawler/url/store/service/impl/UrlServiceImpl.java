package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import com.jasmine.crawler.url.store.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.DownSystemSiteService;
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
public class UrlServiceImpl extends LoggerSupport implements UrlService {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private ConcurrentLinkedQueue<SaveUrlResultReq> queue;

    @Override
    public List<Url> getUrlForTask(GetUrlForTaskReq req) throws Exception {
        DownSystemSite downSystemSite = downSystemSiteService.get(req.getDownSystemSiteId());
        if(Objects.isNull(downSystemSite)){
           throw  new Exception(String.format("down system site (%d) not exists",req.getDownSystemSiteId()));
        }

        RQueue<Url> queue = redissonClient.getQueue(String.format("url_q_%d", req.getDownSystemSiteId()));

        List<Url> urls = new LinkedList<>();

        int size = queue.size();

        // load url from db to redis when cached url count less than task url count
        if (size < downSystemSite.getTaskUrlBatchCount()) {
            info(String.format("load url from db,current cached url %d", size));
            List<Url> urlsToCache = urlMapper.getUrlToCacheForSite(
                    req.getDownSystemSiteId(),
                    downSystemSite.getUrlMaxCacheCount()
            );

            queue.addAll(urlsToCache);
            updateUrlStatusToWait(urls);
            info(String.format(
                    "load %d url tp cache,current cache size %d",
                    urlsToCache.size(),
                    queue.size())
            );
        }

        // poll url from redis
        int t = 0;
        while (t++ < queue.size()) {
            Url url = queue.poll();
            if (Objects.isNull(url))
                break;

            urls.add(url);
        }

        info(String.format("got %d url to run", urls.size()));

        return urls;
    }

    @Override
    public boolean saveUrlResult(SaveUrlResultReq req) {
        queue.add(req);
        return true;
    }

    private void updateUrlStatusToWait(List<Url> urls) {
        List<Url> ls = new LinkedList<>();

        int t = 0;
        for (final Url url : urls) {
            if (t++ % 100 == 0) {
                updateUrlStatusToWait(ls);
                ls = new LinkedList<>();
            }

            ls.add(url);
        }

        updateUrlStatusToWaitCore(ls);
    }

    private void updateUrlStatusToWaitCore(List<Url> urls) {
        try {
            urlMapper.updateUrlStatusToWait(urls);
        } catch (Exception ex) {

        }
    }

}
