/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.cron.mapper.CrawlTaskMapper;
import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawler.cron.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlTaskServiceImpl implements CrawlTaskService {

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

    @Override
    public List<CrawlTask> getTaskToBind(Integer level) {
        return crawlTaskMapper.getTaskToBind(level);
    }

    @Override
    public boolean deleteById(Integer id) {
        return crawlTaskMapper.deleteById(id)>0;
    }

    @Override
    public boolean updateById(Integer id, CrawlTask crawlTaskToUpdate) {
        return crawlTaskMapper.updateById(id,crawlTaskToUpdate)>0;
    }

    @Override
    public boolean add(CrawlTask taskToCreate) {
        return crawlTaskMapper.add(taskToCreate)>0;
    }

    @Override
    public List<CrawlTaskConfig> getTaskConfigToRun() {
        return crawlTaskMapper.getTaskConfigToRun();
    }
}

