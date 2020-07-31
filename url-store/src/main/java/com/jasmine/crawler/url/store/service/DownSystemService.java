package com.jasmine.crawler.url.store.service;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface DownSystemService {
    void increaseNewUrlCount(Integer downSystemId, int size);

    void increaseBadUrlCount(Integer downSystemId, int size);

    void increaseFinishedUrlCount(Integer downSystemId, int size);
}
