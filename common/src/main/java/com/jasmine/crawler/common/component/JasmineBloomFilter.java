package com.jasmine.crawler.common.component;

import java.io.IOException;

public interface JasmineBloomFilter {

    /**
     * Add a url to bloom
     *
     * @param url
     * @return exist false or true
     * @throws Exception
     */
    boolean add(String url) throws Exception;

    /**
     * Init bloom through formatted base64 str
     *
     * @param base64Str
     * @throws IOException
     */
    void load(String base64Str) throws IOException;

    /**
     * Dump bloom to base64 str
     *
     * @return
     * @throws IOException
     */
    String dump() throws IOException;

    /**
     * Init bloom
     *
     * @param expectedInsertions
     * @param fpp
     */
    void init(int expectedInsertions, double fpp);

    /**
     * Mark if filter has been initialized
     *
     * @return
     */
    boolean initialized();

}
