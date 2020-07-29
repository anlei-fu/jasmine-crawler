package com.jasmine.crawler.url.store.job;

import com.jasmine.crawl.common.component.JasmineBloomFilter;
import com.jasmine.crawl.common.pojo.entity.Url;
import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawl.common.constant.UrlStatus;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import com.jasmine.crawler.url.store.pojo.entity.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
@Component
public class UlrConsumeJob extends LoggerSupport {

    @Autowired
    private ConcurrentLinkedQueue<SaveUrlResultReq> urlQueue;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    @Autowired
    private UrlMapper urlMapper;

    public void run() throws IOException {
        info("begin url save job");
        SaveUrlResultReq saveUrlResultReq = urlQueue.poll();

        // no queue n to save
        if (Objects.isNull(saveUrlResultReq)) {
            info("no url to save");
            return;
        }

        JasmineBloomFilter filter = bloomFilterManager.get(saveUrlResultReq.getDownSystemSiteId());
        List<Url> urls = new LinkedList<>();
        int t = 0;
        int k = 0;
        for (final Url url : saveUrlResultReq.getNewUrls()) {
            if (t++ % 100 == 0) {
                saveNewUrl(urls);
                urls = new LinkedList<>();
                k++;
            }
            try {
                if (!Objects.isNull(url.getUrl()) && filter.add(url.getUrl())) {
                    urls.add(url);
                }
            } catch (Exception ex) {
                error(String.format("filter url(%s) failed", url.getUrl()), ex);
            }
        }

        ((JasmineBloomWrapper) filter).increaseTotalCount(k);
        saveNewUrl(urls);

        updateUrlStatus(
                saveUrlResultReq.getSucceedUrls(),
                saveUrlResultReq.getDownSystemSiteId(),
                UrlStatus.SUCCESS
        );

        updateUrlStatus(
                saveUrlResultReq.getFailedUrls(),
                saveUrlResultReq.getDownSystemSiteId(),
                UrlStatus.FAILED
        );

        updateUrlStatus(
                saveUrlResultReq.getBadUrls(),
                saveUrlResultReq.getDownSystemSiteId(),
                UrlStatus.BAD
        );

        updateUrlStatus(
                saveUrlResultReq.getFailedUrls(),
                saveUrlResultReq.getDownSystemSiteId(),
                UrlStatus.FAILED_TO_CRAWL
        );
    }

    private void saveNewUrl(List<Url> newUrls) {
        try {
            urlMapper.addBatch(newUrls);
        } catch (Exception ex) {
            error("add url batch failed", ex);
        }
    }

    private void updateUrlStatus(List<String> urls, Integer downSiteId, Integer urlStatus) {
        if (urlStatus != UrlStatus.FAILED) {
            for (final String url : urls) {
                try {
                    Url urlToUpdate = Url.builder()
                            .downSystemSiteId(downSiteId)
                            .url(url)
                            .urlStatus(urlStatus)
                            .build();
                    urlMapper.updateStatus(urlToUpdate);
                } catch (Exception ex) {
                    error(
                            String.format(
                                    "update url(%s),down site(%d) ,status(%d) failed",
                                    url,
                                    downSiteId,
                                    urlStatus)
                            , ex
                    );
                }
            }
        } else {
            for (final String url : urls) {
                try {
                    Url urlToUpdate = Url.builder()
                            .downSystemSiteId(downSiteId)
                            .url(url)
                            .build();
                    urlMapper.failed(urlToUpdate);
                } catch (Exception ex) {
                    error(
                            String.format(
                                    "update url(%s),down site(%d) ,status(%d) failed",
                                    url,
                                    downSiteId,
                                    UrlStatus.FAILED)
                            , ex
                    );
                }
            }
        }

    }
}
