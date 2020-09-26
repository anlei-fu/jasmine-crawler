/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

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
    public List<Crawler> getCrawlerForSite(Integer siteId, Integer taskUrlMaxConcurrency, boolean useCrawlerIp) {
        return crawlerMapper.getCrawlerForSite(siteId, taskUrlMaxConcurrency, useCrawlerIp);
    }

    @Override
    public void changeCurrentConcurrency(Integer id, Integer concurrencyToChange) {
        crawlerMapper.updateConcurrencyById(id, concurrencyToChange);
    }

    @Override
    public Crawler get(int id) {
        return crawlerMapper.getById(id);
    }

    @Override
    public List<Crawler> getNeedHeartbeatCrawlers() {
        return crawlerMapper.getCrawlersNeedHeartbeat();
    }

    @Override
    public void updateHeartbeatStatus(Integer crawlerId, boolean up) {
        if (up) {
            crawlerMapper.heartbeatSuccess(crawlerId);
        } else {
            crawlerMapper.heartbeatFailed(crawlerId);
        }
    }
}

