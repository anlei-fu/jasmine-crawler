package com.jasmine.crawler.url.store.pojo.entity;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.component.impl.JasmineBloomFilterImpl;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */

public class JasmineBloomWrapper implements JasmineBloomFilter {

    private final Object LOCK = new Object();

    private JasmineBloomFilterImpl innerFilter;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Date lastDumpTime;

    @Getter
    @Setter
    private Date lastActiveTime;

    @Getter
    @Setter
    private Integer totalCount;

    public JasmineBloomWrapper() {
        innerFilter = new JasmineBloomFilterImpl();
    }

    @Override
    public boolean add(String url) throws Exception {
        return innerFilter.add(url);
    }

    @Override
    public void load(String data) throws IOException {
        innerFilter.load(data);
    }

    @Override
    public String dump() throws IOException {
        return innerFilter.dump();
    }

    @Override
    public void init(int expectedInsertions, double fpp) {
        innerFilter.init(expectedInsertions, fpp);
    }

    @Override
    public boolean initialized() {
        return innerFilter.initialized();
    }

    public void increaseTotalCount(Integer count) {
        synchronized (LOCK) {
            totalCount += count;
        }
    }
}
