package com.jasmine.crawler.url.store.service.impl;

import cn.hutool.core.util.StrUtil;
import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.pojo.dto.PageResult;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.common.util.CollectionUtils;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import com.jasmine.crawler.url.store.service.*;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class UrlServiceImpl extends LoggerSupport implements UrlService {

    private static final int URL_INSERT_BATCH_SIZE = 50;

    private static final int URL_UPDATE_BATCH_SIZE = 30;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private DownSystemService downSystemService;

    @Autowired
    private CrawlTaskService crawlTaskService;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    @Override
    public List<Url> getUrlForSite(Integer downSystemSiteId) throws Exception {
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
            updateUrlStatusToCached(urlsToCache);
            info(String.format(
                    "load %d url tp cache,current cache size %d",
                    urlsToCache.size(),
                    queue.size())
            );
        }

        // poll url from redis
        int t = 0;
        size = queue.size();
        while (t++ < size) {
            Url url = queue.poll();
            if (Objects.isNull(url))
                break;

            urls.add(url);
        }

        info(String.format("got %d url to run", urls.size()));

        return urls;
    }

    @Override
    public void saveTaskUrlResult(SaveUrlResultReq req) throws Exception {
        DownSystemSite downSystemSite = downSystemSiteService.get(req.getDownSystemSiteId());
        if (Objects.isNull(downSystemSite)) {
            info("failed to run, down system site not exists");
            return;
        }

        saveNewUrl(req, downSystemSite);
        List<PageResult> failedUrls = new LinkedList<>();
        List<PageResult> badUrls = new LinkedList<>();
        List<PageResult> failedToRunUrls = new LinkedList<>();
        List<PageResult> succeedUrls = new LinkedList<>();
        for (final PageResult pr : req.getPageResults()) {
            pr.setTaskId(req.getTaskId());
            if (pr.getPageResult() == com.jasmine.crawler.common.constant.PageResult.SUCCESS) {
                succeedUrls.add(pr);
            } else if (pr.getPageResult() == com.jasmine.crawler.common.constant.PageResult.FAILED_TO_RUN) {
                failedToRunUrls.add(pr);
            } else if (pr.getPageResult() == com.jasmine.crawler.common.constant.PageResult.BAD) {
                badUrls.add(pr);
            } else {
                failedUrls.add(pr);
            }
        }

        failToRunUrls(failedToRunUrls);
        badUrls(badUrls, downSystemSite);
        failedUrls(failedUrls);
        succeedUrls(succeedUrls, downSystemSite);
        crawlTaskService.syncUrl(req.getTaskId());
    }

    private void updateUrlStatusToCached(List<Url> urls) {
        for (final List<Url> urlGroup : CollectionUtils.split(urls, 100)) {
            try {
                urlMapper.updateUrlStatusToCached(urlGroup);
            } catch (Exception ex) {
                error("update url status to be cached failed", ex);
            }
        }
    }

    private void saveNewUrl(SaveUrlResultReq saveUrlResultReq, DownSystemSite downSystemSite) throws Exception {
        JasmineBloomFilter filter = bloomFilterManager.get(saveUrlResultReq.getDownSystemSiteId());
        if (Objects.isNull(filter)) {
            warn(String.format("can not get bloom filter for down site %d", downSystemSite.getId()));
            return;
        }

        List<Url> newUrls = new LinkedList<>();
        saveUrlResultReq.getPageResults().stream().forEach(result -> {
            if (result.getPageResult() == 1) {
                result.getNewUrls().stream().forEach(url -> {
                    if (url.getUrlType() == null)
                        url.setUrlType(1);

                    url.setDownSystemSiteId(downSystemSite.getId());
                });
                newUrls.addAll(result.getNewUrls());
            }
        });

        List<Url> filteredUrls = new LinkedList<>();
        for (final Url url : newUrls) {
            if (StrUtil.isEmpty(url.getUrl()))
                continue;

            try {
                if (filter.add(url.getUrl())) {
                    filteredUrls.add(url);
                }
            } catch (Exception ex) {

            }
        }

        for (final List<Url> ls : CollectionUtils.split(filteredUrls, URL_INSERT_BATCH_SIZE)) {
            saveNewUrlCore(ls, downSystemSite);
        }
    }

    private void saveNewUrlCore(List<Url> newUrls, DownSystemSite downSystemSite) {
        try {
            urlMapper.addBatch(newUrls);
            downSystemSiteService.increaseNewUrlCount(downSystemSite.getId(), newUrls.size());
            downSystemService.increaseNewUrlCount(downSystemSite.getDownSystemId(), newUrls.size());
            info(String.format("insert %d new url", newUrls.size()));
        } catch (Exception ex) {
            error("add url batch failed", ex);
        }
    }

    private void failedUrls(List<PageResult> urls) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.failedUrls(list);
                info(String.format("failed %d url", list.size()));
            } catch (Exception ex) {
                error("fail url batch failed", ex);
            }
        }
    }

    private void badUrls(List<PageResult> urls, DownSystemSite downSystemSite) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.badUrls(list);
                downSystemSiteService.increaseBadUrlCount(downSystemSite.getId(), list.size());
                downSystemService.increaseBadUrlCount(downSystemSite.getDownSystemId(), list.size());
                downSystemSiteService.increaseFinishedUrlCount(downSystemSite.getId(), list.size());
                downSystemService.increaseFinishedUrlCount(downSystemSite.getDownSystemId(), list.size());
                info(String.format("bad %d url", list.size()));
            } catch (Exception ex) {
                error("bad url batch failed", ex);
            }
        }
    }

    private void failToRunUrls(List<PageResult> urls) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.failToRunUrls(list);
                info(String.format("fail to run %d url", list.size()));
            } catch (Exception ex) {
                error("fail to run url batch failed", ex);
            }
        }
    }

    private void succeedUrls(List<PageResult> urls, DownSystemSite downSystemSite) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.successUrls(list);
                downSystemSiteService.increaseFinishedUrlCount(downSystemSite.getId(), list.size());
                downSystemService.increaseFinishedUrlCount(downSystemSite.getDownSystemId(), list.size());
                info(String.format("succeed %d url", list.size()));
            } catch (Exception ex) {
                error("success url batch failed", ex);
            }
        }
    }
}
