package com.jasmine.crawler.common.support;

import java.util.Date;

public interface Counter {
    void increase(int value);

    boolean overMax();

    Date getLastActive();
}
