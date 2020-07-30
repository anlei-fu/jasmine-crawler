package com.jasmine.crawler.url.store.job;

import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.common.support.LoggerSupport;
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
public class BloomDumpJob extends LoggerSupport {
    private final int DUMP_INTERVAL = 60 * 60 * 1000;

    private final int BLOOM_INACTIVE_TIMEOUT = 60 * 30 * 1000;

    @Autowired
    private BloomMapper bloomMapper;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    /**
     * Bloom job
     * 1. dump bloom and update bloom total
     * 2. unload inactive bloom
     *
     */
    public void run() {
        info("------------------------begin dump and unloading url bloom-------------------------");
        for (final JasmineBloomWrapper wrapper : bloomFilterManager.getAll()) {
            if ((new Date().getTime() - wrapper.getLastDumpTime().getTime()) > DUMP_INTERVAL) {
                dump(wrapper);
            }

            if ((new Date().getTime() - wrapper.getLastActiveTime().getTime()) > BLOOM_INACTIVE_TIMEOUT) {
                dump(wrapper);
                bloomFilterManager.remove(wrapper.getId());
                info(String.format("unloading bloom(%d)",wrapper.getId()));
            }
        }
    }

    private void dump(JasmineBloomWrapper wrapper) {
        try {
            SiteUrlBloom siteUrlBloom = SiteUrlBloom.builder()
                    .totalCount(wrapper.getTotalCount())
                    .bloom(wrapper.dump())
                    .id(wrapper.getId())
                    .build();
            bloomMapper.update(siteUrlBloom);
            info(String.format("dump bloom(%d)",wrapper.getId()));
        } catch (Exception ex) {
            error(String.format("dump bloom(%d) failed",wrapper.getId()),ex);
        }
    }

}
