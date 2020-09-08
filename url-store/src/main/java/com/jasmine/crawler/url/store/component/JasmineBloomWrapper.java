package com.jasmine.crawler.url.store.component;

import com.jasmine.crawler.common.component.JasmineBloomFilter;
import com.jasmine.crawler.common.component.impl.JasmineBloomFilterImpl;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Date;

public class JasmineBloomWrapper implements JasmineBloomFilter {

    private JasmineBloomFilterImpl innerFilter;

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private long lastDumpTime = System.currentTimeMillis();

    @Getter
    @Setter
    private long lastActiveTime = System.currentTimeMillis();

    public JasmineBloomWrapper() {
        innerFilter = new JasmineBloomFilterImpl();
    }

    @Override
    public boolean add(String url) throws Exception {
        lastActiveTime=System.currentTimeMillis();
        return innerFilter.add(url);
    }

    @Override
    public void load(String data) throws IOException {
        innerFilter.load(data);
    }

    @Override
    public String dump() throws IOException {
        lastDumpTime=System.currentTimeMillis();
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

}
