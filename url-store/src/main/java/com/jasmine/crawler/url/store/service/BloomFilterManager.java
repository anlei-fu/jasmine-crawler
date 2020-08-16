package com.jasmine.crawler.url.store.service;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.url.store.component.JasmineBloomWrapper;

import java.io.IOException;

public interface BloomFilterManager {

    /**
     * Get bloom filter for down system site
     *
     * @param downSystemSiteId
     * @return
     * @throws Exception
     */
    JasmineBloomFilter get(Integer downSystemSiteId) throws Exception;

    /**
     * Get all loaded bloom filter
     *
     * @return
     */
    Iterable<JasmineBloomWrapper> getAll();

    /**
     * Unload  bloom filter by down system site id
     *
     * @param downSystemSiteId
     */
    void remove(Integer downSystemSiteId) throws IOException;

}
