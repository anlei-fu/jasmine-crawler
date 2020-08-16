package com.jasmine.crawler.url.store.service;

public interface DownSystemService {

    /**
     * Increase new url count
     *
     * @param downSystemId
     * @param size
     */
    void increaseNewUrlCount(Integer downSystemId, int size);

    /**
     * Increase bad url count
     *
     * @param downSystemId
     * @param size
     */
    void increaseBadUrlCount(Integer downSystemId, int size);

    /**
     * Increase finished url count
     *
     * @param downSystemId
     * @param size
     */
    void increaseFinishedUrlCount(Integer downSystemId, int size);
}
