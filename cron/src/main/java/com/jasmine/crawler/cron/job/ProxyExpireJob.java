package com.jasmine.crawler.cron.job;

import com.jasmine.crawler.common.pojo.entity.Proxy;
import com.jasmine.crawler.common.support.LoggerSupport;
import com.jasmine.crawler.cron.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProxyExpireJob extends LoggerSupport {

    @Autowired
    private ProxyService proxyService;

    public void run() {
        info(String.format("-----------------begin disable expired proxy job----------------"));
        List<Proxy> proxies = null;
        try {
                proxyService.disableBlockedProxies();
        } catch (Exception ex) {
            error("disable proxies failed", ex);
        }


    }
}
