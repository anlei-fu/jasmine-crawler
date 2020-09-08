package com.jasmine.crawler.url.store.job;

import com.jasmine.crawler.common.pojo.entity.SiteUrlBloom;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.url.store.component.JasmineBloomWrapper;
import com.jasmine.crawler.url.store.mapper.BloomMapper;
import com.jasmine.crawler.url.store.service.BloomFilterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class BloomDumpJob extends LoggerSupport {

    private final int DUMP_INTERVAL = 10 * 1000 * 60;

    private final int BLOOM_INACTIVE_TIMEOUT = 60 * 30 * 1000;

    @Autowired
    private BloomMapper bloomMapper;

    @Autowired
    private BloomFilterManager bloomFilterManager;

    /**
     * Bloom job
     * 1. dump bloom
     * 2. unload inactive bloom
     */
    @Scheduled(cron = "0 0/5 * * * ?")
    public void run() throws IOException {
        info("------------------------begin dumping and unloading url bloom-------------------------");
        for (final JasmineBloomWrapper wrapper : bloomFilterManager.getAll()) {
            if ((System.currentTimeMillis() - wrapper.getLastDumpTime()) > DUMP_INTERVAL) {
                dump(wrapper);
            }

            if ((System.currentTimeMillis() - wrapper.getLastActiveTime()) > BLOOM_INACTIVE_TIMEOUT) {
                dump(wrapper);
                bloomFilterManager.remove(wrapper.getId());
                info(String.format("unloading bloom(%d)", wrapper.getId()));
            }
        }
    }

    private void dump(JasmineBloomWrapper wrapper) {
        try {
            SiteUrlBloom siteUrlBloom = SiteUrlBloom.builder()
                    .bloom(wrapper.dump())
                    .id(wrapper.getId())
                    .build();
            bloomMapper.dump(siteUrlBloom);
            info(String.format("dump bloom(%d)", wrapper.getId()));
        } catch (Exception ex) {
            error(String.format("dump bloom(%d) failed", wrapper.getId()), ex);
        }
    }

}
