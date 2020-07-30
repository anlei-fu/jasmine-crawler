package com.jasmine.crawler.common.component.impl;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.jasmine.crawler.common.component.JasmineBloomFilter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;

public class JasmineBloomFilterImpl implements JasmineBloomFilter {

    private BloomFilter<CharSequence> innerFilter;

    private boolean _initialized;

    @Override
    public boolean add(String url) throws Exception {
        if (!initialized())
            throw new Exception("has not been initialized");

        return innerFilter.put(url);
    }

    @Override
    public void load(String data) throws IOException {
        if (this._initialized)
            return;

        this.innerFilter = BloomFilter.readFrom(
                new ByteArrayInputStream(Base64.getDecoder().decode(data)),
                Funnels.stringFunnel(Charset.forName("utf8"))
        );

        this._initialized = true;
    }

    @Override
    public String dump() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
        innerFilter.writeTo(out);
        return Base64.getEncoder().encodeToString(out.toByteArray());
    }

    @Override
    public void init(int expectedInsertions, double fpp) {
        if (this._initialized)
            return;

        this.innerFilter = BloomFilter.create(
                Funnels.stringFunnel(Charset.forName("utf8")),
                expectedInsertions,
                fpp
        );

        this._initialized = true;
    }

    @Override
    public boolean initialized() {
        return this._initialized;
    }
}
