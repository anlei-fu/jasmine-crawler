package com.jasmine.crawler.url.store.job;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.pojo.entity.DownSystemSite;
import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.common.util.CollectionUtils;
import com.jasmine.crawler.url.store.mapper.UrlMapper;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import com.jasmine.crawler.url.store.service.DownSystemService;
import com.jasmine.crawler.url.store.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class UlrConsumeJob extends LoggerSupport {

    private static final int URL_INSERT_BATCH_SIZE = 50;

    private static final int URL_UPDATE_BATCH_SIZE = 30;

    @Autowired
    private ConcurrentLinkedQueue<SaveUrlResultReq> urlResultQueue;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    @Autowired
    private UrlMapper urlMapper;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Autowired
    private DownSystemService downSystemService;

    /**
     * Save url result job
     * 1. update url status
     * 2. save new url
     * 3. increase down system site url total and finished
     * 4. increase down system site url total and finished
     * 5. increase site url total and finished
     *
     * @throws IOException
     */
    public void run() throws Exception {
        info("------------begin url save job-----------------");
        SaveUrlResultReq saveUrlResultReq = urlResultQueue.poll();

        // no queue n to save
        if (Objects.isNull(saveUrlResultReq)) {
            info("no url result poll to save");
            return;
        }

        DownSystemSite downSystemSite = downSystemSiteService.get(saveUrlResultReq.getDownSystemSiteId());
        if (Objects.isNull(downSystemSite)) {
            info("failed to run, down system site not exists");
            return;
        }

        saveNewUrl(saveUrlResultReq, downSystemSite);
        succeedUrls(saveUrlResultReq.getSucceedUrls(), downSystemSite);
        badUrls(saveUrlResultReq.getBadUrls(), downSystemSite);
        failedUrls(saveUrlResultReq.getFailedUrls(), downSystemSite.getId());
        failToRunUrls(saveUrlResultReq.getFailedUrls());
    }

    private void saveNewUrl(SaveUrlResultReq saveUrlResultReq, DownSystemSite downSystemSite) throws Exception {
        JasmineBloomFilter filter = bloomFilterManager.get(saveUrlResultReq.getDownSystemSiteId());
        if (Objects.isNull(filter)) {
            warn(String.format("can not get bloom filter for down site %d", downSystemSite.getId()));
            return;
        }

        List<Url> urls = new LinkedList<>();
        int t = 0;
        int k = 0;
        for (final Url url : saveUrlResultReq.getNewUrls()) {
            if (t++ % URL_INSERT_BATCH_SIZE == 0) {
                saveNewUrlCore(urls, downSystemSite);
                urls = new LinkedList<>();
            }

            try {
                if (!Objects.isNull(url.getUrl()) && filter.add(url.getUrl())) {
                    urls.add(url);
                    k++;
                }
            } catch (Exception ex) {
                error(String.format("filter url(%s) failed", url.getUrl()), ex);
            }
        }

        saveNewUrlCore(urls, downSystemSite);
    }

    private void saveNewUrlCore(List<Url> newUrls, DownSystemSite downSystemSite) {
        try {
            urlMapper.addBatch(newUrls);
            downSystemSiteService.increaseNewUrlCount(downSystemSite.getId(), newUrls.size());
            downSystemService.increaseNewUrlCount(downSystemSite.getDownSystemId(), newUrls.size());
        } catch (Exception ex) {
            error("add url batch failed", ex);
        }
    }

    private void failedUrls(List<Integer> urls, Integer downSystemSiteId) {
        for (List<Integer> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.failedUrls(list);
            } catch (Exception ex) {
                error("fail url batch failed", ex);
            }
        }
    }

    private void badUrls(List<Integer> urls, DownSystemSite downSystemSite) {
        for (List<Integer> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.badUrls(list);
                downSystemSiteService.increaseBadUrlCount(downSystemSite.getId(), list.size());
                downSystemService.increaseBadUrlCount(downSystemSite.getDownSystemId(), list.size());
            } catch (Exception ex) {
                error("bad url batch failed", ex);
            }
        }
    }

    private void failToRunUrls(List<Integer> urls) {
        for (List<Integer> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.failToRunUrls(list);
            } catch (Exception ex) {
                error("fail to run url batch failed", ex);
            }
        }
    }

    private void succeedUrls(List<Integer> urls, DownSystemSite downSystemSite) {
        for (List<Integer> list : CollectionUtils.split(urls, URL_UPDATE_BATCH_SIZE)) {
            try {
                urlMapper.successUrls(list);
                downSystemSiteService.increaseFinishedUrlCount(downSystemSite.getId(), list.size());
                downSystemService.increaseFinishedUrlCount(downSystemSite.getDownSystemId(), list.size());
            } catch (Exception ex) {
                error("success url batch failed", ex);
            }
        }
    }

}
