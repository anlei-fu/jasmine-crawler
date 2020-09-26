package com.jasmine.crawler.common.component;

public interface StringMatcher {

    /**
     * To check if target url matched
     *
     * @param url
     * @return
     */
    boolean match(String url);
}
