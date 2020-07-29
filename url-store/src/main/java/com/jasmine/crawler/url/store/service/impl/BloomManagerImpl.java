package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawl.common.component.JasmineBloomFilter;
import com.jasmine.crawl.common.pojo.entity.DownSystemSite;
import com.jasmine.crawl.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.pojo.entity.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import com.jasmine.crawler.url.store.service.DownSystemSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class BloomManagerImpl implements BloomFilterManager {

    private ConcurrentHashMap<Integer, JasmineBloomWrapper> cache = new ConcurrentHashMap<>();

    @Autowired
    private BloomMapper bloomMapper;

    @Autowired
    private DownSystemSiteService downSystemSiteService;

    @Override
    public JasmineBloomFilter get(Integer id) throws IOException {
        if (cache.containsKey(id)) {
            JasmineBloomWrapper wrapper = cache.get(id);
            wrapper.setLastActiveTime(new Date());
            return (JasmineBloomFilter) bloomMapper;
        }

        SiteUrlBloom siteUrlBloom = bloomMapper.getForUpdate(id);
        if (Objects.isNull(siteUrlBloom)) {
            return createBloom(id);
        } else {
            JasmineBloomWrapper wrapper = new JasmineBloomWrapper();
            wrapper.load(siteUrlBloom.getBloom());
            cache.put(id, wrapper);
            wrapper.setTotalCount(siteUrlBloom.getTotalCount());
            return wrapper;
        }
    }

    @Override
    public Iterable<JasmineBloomWrapper> getAll() {
        return cache.values();
    }

    @Override
    public void remove(Integer id) {
        cache.remove(id);
    }

    private JasmineBloomFilter createBloom(Integer id) throws IOException {

        JasmineBloomWrapper wrapper = new JasmineBloomWrapper();
        DownSystemSite downSystemSite = downSystemSiteService.get(id);
        wrapper.init(downSystemSite.getExpectedUrlSize(), downSystemSite.getFpp());
        SiteUrlBloom siteUrlBloom = SiteUrlBloom
                .builder()
                .id(id)
                .bloom(wrapper.dump())
                .build();
        bloomMapper.add(siteUrlBloom);
        cache.put(id, wrapper);
        wrapper.setTotalCount(0);
        return wrapper;
    }

}
