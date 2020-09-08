package com.jasmine.crawler.common.support;

import java.util.Date;

public interface Counter {
    boolean addAndCheck(int value);

    boolean isExists();

    long getLastActive();
}
