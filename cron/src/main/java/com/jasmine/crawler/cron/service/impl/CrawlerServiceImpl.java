/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.constant.BooleanFlag;
import com.jasmine.crawler.common.pojo.entity.Crawler;
import com.jasmine.crawler.cron.mapper.CrawlerMapper;
import com.jasmine.crawler.cron.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    private CrawlerMapper crawlerMapper;

    @Override
    public Crawler getCrawlerForSite(Integer siteId, Integer taskUrlMaxConcurrency, boolean withIp) {
        return crawlerMapper.getCrawlerForSite(siteId, taskUrlMaxConcurrency, withIp);
    }

    @Override
    public void changeCurrentConcurrency(Integer id, Integer concurrencyToIncrease) {
        crawlerMapper.updateConcurrencyById(id, concurrencyToIncrease);
    }

    @Override
    public Crawler get(int crawlerId) {
        return crawlerMapper.getById(crawlerId);
    }

    @Override
    public List<Crawler> getCrawlersNeedHeartbeat() {
        return crawlerMapper.getCrawlersNeedHeartbeat();
    }

    @Override
    public void updateHeartbeatStatus(Integer crawlerId, boolean isUp) {
        if (isUp) {
            crawlerMapper.heartbeatSuccess(crawlerId);
        } else {
            crawlerMapper.heartbeatFailed(crawlerId);
        }
    }
}

