package com.jasmine.crawler.url.store.service;

public interface DownSystemService {

    /**
     * Add new url count
     *
     * @param downSystemId
     * @param count
     */
    void addNewUrlCount(Integer downSystemId, int count);

    /**
     * Add bad url count
     *
     * @param downSystemId
     * @param count
     */
    void addBadUrlCount(Integer downSystemId, int count);

    /**
     * Add finished url count
     *
     * @param downSystemId
     * @param count
     */
    void addFinishedUrlCount(Integer downSystemId, int count);
}
