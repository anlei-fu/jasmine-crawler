/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;

import java.util.List;

/**
 * Crawl task manager
 */
public interface CrawlTaskService {

    /**
     * Add crawl task
     *
     * @param taskToCreate
     * @return
     */
    boolean add(CrawlTask taskToCreate);

    /**
     * Delete crawl task by id
     *
     * @param taskId
     * @return
     */
    boolean delete(Integer taskId);

    /**
     * Get crawl tasks to bind
     *
     * @param level
     * @return
     */
    List<CrawlTask> getTasksToBind(Integer level);

    /**
     * Handle bind failed
     *
     * @param taskToUpdate
     */
    void bindFailed(CrawlTask taskToUpdate);

    /**
     * Handle bind success
     *
     * @param taskToUpdate
     * @return
     */
    boolean bindSuccess(CrawlTask taskToUpdate);

    /**
     * Get crawl tasks config to dispatch
     *
     * @return
     */
    List<CrawlTaskConfig> getTasksConfigsToDispatch();

    /**
     * Update crawl task to bind
     *
     *
     * @param downSystemSiteId
     * @param downSystemSiteId
     * @return
     */
    boolean dispatchSuccess(Integer taskId, Integer downSystemSiteId);

    /**
     * Update task when dispatch failed
     *
     * @param dispatchFailedTask
     */
    void dispatchFailed(CrawlTask dispatchFailedTask);

    /**
     * Get timeout crawl tasks to terminate
     *
     * @return
     */
    List<CrawlTask> getTimeoutTasksToTerminate();

    /**
     * Terminate timeout crawl task
     *
     * @param taskId
     */
    void terminateExecuteTimeoutTask(Integer taskId);

    /**
     * Get task and lock it
     *
     * @param taskId
     * @return
     */
    CrawlTask getForUpdate(Integer taskId);

    void bindTimeout(Integer id);

    List<CrawlTask> getBindTimeoutTasks();

    CrawlTask get(Integer taskId);
}
