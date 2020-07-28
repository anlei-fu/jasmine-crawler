package com.jasmine.crawler.url.store.job;

import com.jasmine.crawl.common.component.QueueManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Component
public class UlrConsumeJob {

    @Autowired
    private QueueManager queueManager;

    public  void  run(){

    }
}
