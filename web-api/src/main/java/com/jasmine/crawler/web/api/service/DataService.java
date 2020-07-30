package com.jasmine.crawler.web.api.service;

import com.jasmine.crawler.web.api.pojo.req.SaveDataResultReq;

public interface DataService {

    /**
     * Save task data
     *
     * @param saveDataResultReq
     */
    void saveData(SaveDataResultReq saveDataResultReq);
}
