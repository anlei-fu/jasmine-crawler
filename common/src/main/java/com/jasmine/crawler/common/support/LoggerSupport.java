package com.jasmine.crawler.common.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerSupport {
    private final Logger LOG;

    public LoggerSupport() {
        this.LOG = LoggerFactory.getLogger(this.getClass());
    }

    protected void info(String msg) {
        LOG.info(msg);
    }

    protected void warn(String msg) {
        LOG.warn(msg);
    }

    protected void error(String msg, Exception ex) {
        LOG.error(msg, ex);
    }
}
