package com.jasmine.crawler.common.support;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface Counter {
    void increase(int value);
    boolean overMax();
    Date getLastActive();
}
