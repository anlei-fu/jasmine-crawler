package com.jasmine.crawler.url.store.service.impl;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.url.store.component.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class BloomManagerImpl implements BloomFilterManager {

    private ConcurrentHashMap<Integer, JasmineBloomWrapper> cache = new ConcurrentHashMap<>();

    @Autowired
    private BloomMapper bloomMapper;

    @Override
    public JasmineBloomFilter get(Integer downSystemSiteId) throws Exception {
        if (cache.containsKey(downSystemSiteId)) {
            JasmineBloomWrapper wrapper = cache.get(downSystemSiteId);
            wrapper.setLastActiveTime(System.currentTimeMillis());
            return (JasmineBloomFilter) wrapper;
        }

        SiteUrlBloom siteUrlBloom = bloomMapper.get(downSystemSiteId);
        if (Objects.isNull(siteUrlBloom)) {
            throw new Exception(String.format("bloom of site(%d) not exists", downSystemSiteId));
        } else {
            JasmineBloomWrapper wrapper = new JasmineBloomWrapper();
            wrapper.load(siteUrlBloom.getBloom());
            wrapper.setId(downSystemSiteId);
            cache.putIfAbsent(downSystemSiteId, wrapper);
            return cache.get(downSystemSiteId);
        }
    }

    @Override
    public Iterable<JasmineBloomWrapper> getAll() {
        return cache.values();
    }

    @Override
    public void remove(Integer downSystemSiteId) throws IOException {
        JasmineBloomWrapper wrapper = cache.get(downSystemSiteId);
        if (!Objects.isNull(wrapper)) {
            SiteUrlBloom siteUrlBloom = SiteUrlBloom.builder()
                    .id(downSystemSiteId)
                    .bloom(wrapper.dump())
                    .build();
            bloomMapper.dump(siteUrlBloom);
            cache.remove(downSystemSiteId);
        }
    }
}
