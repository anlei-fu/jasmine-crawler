package com.jasmine.crawl.common.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class LoggerSupport {
    private final Logger LOG ;

    public  LoggerSupport(){
        this.LOG= LoggerFactory.getLogger(this.getClass());
    }

    protected  void  info(String msg){
        LOG.info(msg);
    }

    protected  void  error(String msg ,Exception e){
        LOG.error(msg,e);
    }
}
