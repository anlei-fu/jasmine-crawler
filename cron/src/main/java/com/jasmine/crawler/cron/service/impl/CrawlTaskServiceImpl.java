/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service.impl;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.mapper.CrawlTaskMapper;
import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawler.cron.service.CrawlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrawlTaskServiceImpl implements CrawlTaskService {

    @Autowired
    private CrawlTaskMapper crawlTaskMapper;

    @Override
    public List<CrawlTask> getTasksToBind(Integer level) {
        if (level > 5) {
            return crawlTaskMapper.getTaskToBindLowestLevel();
        }

        Integer bindCountMin = (level - 1) * 5;
        Integer bindCountMax = level * 5;
        return crawlTaskMapper.getTaskToBind(bindCountMin, bindCountMax);
    }

    @Override
    public boolean delete(Integer taskId) {
        return crawlTaskMapper.deleteById(taskId) > 0;
    }

    @Override
    public boolean dispatchSuccess(Integer id, Integer downSystemSiteId) {
        return crawlTaskMapper.dispatchSuccess(id,downSystemSiteId) > 0;
    }

    @Override
    public boolean add(CrawlTask taskToCreate) {
        return crawlTaskMapper.add(taskToCreate) > 0;
    }

    @Override
    public List<CrawlTaskConfig> getTasksConfigsToDispatch() {
        return crawlTaskMapper.getTaskConfigsToDispatch();
    }

    @Override
    public List<CrawlTask> getTimeoutTasksToTerminate() {
        return crawlTaskMapper.getTimeoutTasksToTerminate();
    }

    @Override
    public void bindFailed(CrawlTask taskToUpdate) {
        crawlTaskMapper.bindFailed(taskToUpdate);
    }

    @Override
    public boolean bindSuccess(CrawlTask taskToUpdate) {
        return crawlTaskMapper.bindSuccess(taskToUpdate);
    }

    @Override
    public void terminateExecuteTimeoutTask(Integer id) {
        crawlTaskMapper.terminateExecuteTimeoutTask(id);
    }

    @Override
    public void dispatchFailed(CrawlTask dispatchFailedTask) {
        crawlTaskMapper.dispatchFailed(dispatchFailedTask);
    }

    @Override
    public CrawlTask getForUpdate(Integer id) {
        return crawlTaskMapper.getForUpdate(id);
    }

    @Override
    public void bindTimeout(Integer id) {
        crawlTaskMapper.bindTimeout(id);
    }

    @Override
    public List<CrawlTask> getBindTimeoutTasks() {
        return crawlTaskMapper.getBindTimeoutTasks();
    }

    @Override
    public CrawlTask get(Integer taskId) {
        return crawlTaskMapper.getById(taskId);
    }
}

