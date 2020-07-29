package com.jasmine.crawler.url.store.job;

import com.jasmine.crawl.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.pojo.entity.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class BloomDumpJob {
    private final int DUMP_INTERVAL = 60 * 60 * 1000;

    private final int UNLOAD_INTERVAL = 60 * 30 * 1000;

    @Autowired
    private BloomMapper bloomMapper;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    public void run() {
        for (final JasmineBloomWrapper wrapper : bloomFilterManager.getAll()) {
            if ((new Date().getTime() - wrapper.getLastDumpTime().getTime()) > DUMP_INTERVAL) {
                dump(wrapper);
            }

            if ((new Date().getTime() - wrapper.getLastActiveTime().getTime()) > UNLOAD_INTERVAL) {
                dump(wrapper);
                bloomFilterManager.remove(1);
            }
        }
    }

    private void dump(JasmineBloomWrapper wrapper) {
        try {
            SiteUrlBloom siteUrlBloom = SiteUrlBloom.builder()
                    .totalCount(wrapper.getTotalCount())
                    .bloom(wrapper.dump())
                    .id(1)
                    .build();
            bloomMapper.update(siteUrlBloom);
        } catch (Exception ex) {

        }
    }

}
