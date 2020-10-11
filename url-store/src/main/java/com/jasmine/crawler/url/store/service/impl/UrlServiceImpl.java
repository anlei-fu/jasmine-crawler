package com.jasmine.crawler.url.store.service.impl;

import cn.hutool.core.util.StrUtil;
import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.constant.UrlType;
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

    private static final int URL_INSERT_BATCH_SIZE = 200;

    private static final int URL_UPDATE_BATCH_SIZE = 200;

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

    /**
     * Get url for downSystemSite
     * fetch urls from redis if cache satisfied or load urls from db to redis and fetch
     *
     * @param downSystemSiteId
     * @return
     * @throws Exception
     */
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
                    "load %d url to cache,current cache size %d",
                    urlsToCache.size(),
                    queue.size())
            );
        }

        // poll url from redis
        int t = 0;
        size = queue.size();
        while (t++ < size) {
            Url url = queue.poll();
            if (Objects.isNull(url) || t > downSystemSite.getTaskUrlBatchCount())
                break;

            urls.add(url);
        }

        info(String.format("got %d url to run", urls.size()));

        return urls;
    }

    /**
     * Add new urls
     * filter with bloom filter
     *
     * @param newUrls
     * @param downSystemSiteId
     * @return
     * @throws Exception
     */
    @Override
    public int addNewUrl(List<Url> newUrls, Integer downSystemSiteId) throws Exception {
        JasmineBloomFilter filter = bloomFilterManager.get(downSystemSiteId);
        if (Objects.isNull(filter)) {
            warn(String.format("can not get bloom filter for down system site(%d)", downSystemSiteId));
            return 0;
        }

        List<Url> filteredUrls = new LinkedList<>();
        for (final Url url : newUrls) {
            if (StrUtil.isEmpty(url.getUrl()))
                continue;

            try {
                if (filter.add(url.getUrl())) {
                    filteredUrls.add(url);

                    if (url.getUrlType() == null)
                        url.setUrlType(UrlType.ONCE);

                    url.setDownSystemSiteId(downSystemSiteId);
                }

            } catch (Exception ex) {
                error(String.format("filter url(%s) failed", url.getUrl()), ex);
            }
        }

        for (final List<Url> ls : CollectionUtils.split(filteredUrls, URL_INSERT_BATCH_SIZE)) {
            addNewUrlCore(ls, downSystemSiteId);
        }
        return filteredUrls.size();
    }

    /**
     * Save url result
     * 1. normal url result
     *    task id is not null and downSystemSiteId is null,
     * 2.dispatch url result
     *    task id is null and downSystemSiteId is not null
     *
     * @param req
     * @throws Exception
     */
    @Override
    public void saveUrlResult(SaveUrlResultReq req) throws Exception {
        DownSystemSite downSystemSite = downSystemSiteService.get(req.getDownSystemSiteId());
        if (Objects.isNull(downSystemSite)) {
            info("failed to run, down system site not exists");
            return;
        }

        if (!Objects.isNull(req.getTaskId())) {
            saveNormalUrlResult(req, downSystemSite);
        } else {
            req.getPageResults().stream().forEach(result -> {
                List<Url> newUrls = new LinkedList<>();
                newUrls.addAll(result.getNewUrls());
                try {
                    addNewUrl(newUrls, result.getDownSystemSiteId());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });

        }
    }

    /**
     * Save normal task url result
     *
     * @param req
     * @param downSystemSite
     * @throws Exception
     */
    private void saveNormalUrlResult(SaveUrlResultReq req, DownSystemSite downSystemSite) throws Exception {
        List<Url> newUrls = new LinkedList<>();
        req.getPageResults().stream().forEach(result -> {
            if (result.getPageResult() == com.jasmine.crawler.common.constant.PageResult.SUCCESS) {
                newUrls.addAll(result.getNewUrls());
            }
        });

        int newUrlCount = addNewUrl(newUrls, downSystemSite.getId());

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
        crawlTaskService.syncUrl(req.getTaskId(), newUrlCount);
    }

    /**
     * Update url status to cached
     *
     * @param urls
     */
    private void updateUrlStatusToCached(List<Url> urls) {
        for (final List<Url> urlGroup : CollectionUtils.split(urls, 100)) {
            try {
                urlMapper.updateUrlStatusToCached(urlGroup);
            } catch (Exception ex) {
                error("update url status to be cached failed", ex);
            }
        }
    }

    /**
     * Insert new urls and add new url count of both downSystemSite and downSystem
     *
     * @param newUrls
     * @param downSystemSiteId
     */
    private void addNewUrlCore(List<Url> newUrls, Integer downSystemSiteId) {
        try {
            urlMapper.addBatch(newUrls);
            downSystemSiteService.addNewUrlCount(downSystemSiteId, newUrls.size());
            downSystemService.addNewUrlCount(downSystemSiteId, newUrls.size());
            info(String.format("insert %d new url", newUrls.size()));
        } catch (Exception ex) {
            error("add url batch failed", ex);
        }
    }

    /**
     * Update url status to finished and result is failed
     *
     * @param urls
     */
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

    /**
     * Update url status to bad and add bad url count of both downSystemSite and downSystem
     *
     * @param urls
     * @param downSystemSite
     */
    private void badUrls(List<PageResult> urls, DownSystemSite downSystemSite) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.badUrls(list);
                downSystemSiteService.addBadUrlCount(downSystemSite.getId(), list.size());
                downSystemService.addBadUrlCount(downSystemSite.getDownSystemId(), list.size());
                downSystemSiteService.addFinishedUrlCount(downSystemSite.getId(), list.size());
                downSystemService.addFinishedUrlCount(downSystemSite.getDownSystemId(), list.size());
                info(String.format("bad %d url", list.size()));
            } catch (Exception ex) {
                error("bad url batch failed", ex);
            }
        }
    }

    /**
     * Update urls status to wait
     *
     * @param urls
     */
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

    /**
     * update url status to finished and add finished url count of both downSystemSite and downSystem
     *
     * @param urls
     * @param downSystemSite
     */
    private void succeedUrls(List<PageResult> urls, DownSystemSite downSystemSite) {
        for (List<PageResult> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.succeedUrls(list);
                downSystemSiteService.addFinishedUrlCount(downSystemSite.getId(), list.size());
                downSystemService.addFinishedUrlCount(downSystemSite.getDownSystemId(), list.size());
                info(String.format("succeed %d url", list.size()));
            } catch (Exception ex) {
                error("success url batch failed", ex);
            }
        }
    }
}
