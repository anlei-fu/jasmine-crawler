package com.jasmine.crawler.common.component.impl;

import com.jasmine.crawler.common.component.StringMatcher;

import java.util.regex.Pattern;

public class JasmineStringMatcher implements StringMatcher {

    private final Pattern pattern;

    public JasmineStringMatcher(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean match(String url) {
        return pattern.matcher(url).matches();
    }
}
