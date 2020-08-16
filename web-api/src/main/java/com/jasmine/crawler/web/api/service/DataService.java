package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.web.api.pojo.req.SaveTaskDataReq;

public interface DataService {

    /**
     * Save task data
     *
     * @param saveTaskDataReq
     */
    void saveData(SaveTaskDataReq saveTaskDataReq);
}
