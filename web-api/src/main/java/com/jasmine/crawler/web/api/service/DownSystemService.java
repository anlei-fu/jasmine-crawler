package com.jasmine.crawler.web.api.service;

public interface DownSystemService {
    /**
     * Decrease current running task count
     *
     * @param downSystemId
     */
    void decreaseCurrentRunningTaskCount(Integer downSystemId);
}
