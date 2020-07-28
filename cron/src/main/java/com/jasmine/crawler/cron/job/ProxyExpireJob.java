package com.jasmine.crawler.cron.job;

import com.jasmine.crawl.common.support.LoggerSupport;
import com.jasmine.crawl.common.pojo.entity.Proxy;
import com.jasmine.crawler.cron.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class ProxyExpireJob extends LoggerSupport {

    @Autowired
    private ProxyService proxyService;

    public void run() {
        info(String.format("-----------------begin proxy expire job----------------"));
        List <Proxy> proxies=null;
        try {

           proxies  =proxyService.getExpiredProxies();
           if(proxies.size()==0){
               info("no proxy need to be disabled");
           }else {
               info(String.format("get %d proxy to disable", proxies.size()));
               proxyService.disableProxiesBatch(getProxyIds(proxies));
           }
        } catch (Exception ex) {
           error("disable proxies failed",ex);
        }

        try {
             proxies =proxyService.getDisableTimeoutProxies();
             if(proxies.size()==0){
                 info("no proxy need to be enabled");
                 return;
             }

            info(String.format("get %d proxy to enable",proxies.size()));
             proxyService.enableProxiesBatch(getProxyIds(proxies));

        } catch (Exception ex) {
            error("enable proxies failed",ex);
        }
    }

    private  List<Integer> getProxyIds(List<Proxy> proxies){
        return  null;
    }
}
