/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.CrawlerMapper;
import com.jasmine.crawl.common.pojo.entity.Crawler;
import com.jasmine.crawler.cron.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlerServiceImpl implements CrawlerService {

    @Autowired
    private CrawlerMapper crawlerMapper;

    @Override
    public Crawler getCrawlerBySite(Integer siteId) {
        return crawlerMapper.getCrawlerBySite(siteId);
    }

    @Override
    public void updateConcurrencyById(Integer id, Integer currentConcurrency) {
         crawlerMapper.updateConcurrencyById(id,currentConcurrency);
    }

    @Override
    public Crawler getById(int id) {
        return crawlerMapper.getById(id);
    }

    @Override
    public List<Crawler> getCrawlerNeedHeartbeat() {
        return crawlerMapper.getCrawlerNeedHeartbeat();
    }

    @Override
    public void updateHeartbeatStatusById(Integer id, Crawler crawler) {
        crawlerMapper.updateHeartbeatStatusById(id,crawler);
    }
}

