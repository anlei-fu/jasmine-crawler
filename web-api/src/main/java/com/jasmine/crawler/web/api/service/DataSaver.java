package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.common.pojo.req.SaveTaskDataReq;

public interface DataSaver {

    /**
     * Save task data
     *
     * @param saveTaskDataReq
     */
    void saveData(SaveTaskDataReq saveTaskDataReq);
}
