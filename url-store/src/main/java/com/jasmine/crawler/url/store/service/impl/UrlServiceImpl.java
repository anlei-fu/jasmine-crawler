package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.common.util.CollectionUtils;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
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
    public List<Url> getUrlForTask(Integer downSystemSiteId) throws Exception {
        DownSystemSite downSystemSite = downSystemSiteService.get(downSystemSiteId);
        if (Objects.isNull(downSystemSite)) {
            throw new Exception(String.format("down system site (%d) not exists", downSystemSiteId));
        }

        RQueue<Url> queue = redissonClient.getQueue(String.format("url_q_%d", downSystemSiteId));
        List<Url> urls = new LinkedList<>();
        int size = queue.size();

        // load url from db to redis when cached url count less than task url count
        if (size < downSystemSite.getTaskUrlBatchCount()) {
            info(String.format("load url from db,current cached url %d", size));
            List<Url> urlsToCache = urlMapper.getUrlToCacheForSite(
                    downSystemSiteId,
                    downSystemSite.getUrlMaxCacheCount()
            );

            queue.addAll(urlsToCache);
            updateUrlStatusToCached(urls);
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
    public boolean saveTaskUrlResult(SaveUrlResultReq req) {
        queue.add(req);
        return true;
    }

    private void updateUrlStatusToCached(List<Url> urls) {
        for (final List<Url> urlGroup : CollectionUtils.split(urls, 100)) {
            try {
                urlMapper.updateUrlStatusToCached(urlGroup);
            } catch (Exception ex) {

            }
        }
    }
}
