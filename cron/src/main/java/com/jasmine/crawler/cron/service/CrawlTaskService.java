/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import com.jasmine.crawler.cron.pojo.req.CrawlTaskConfig;

import java.util.List;

/**
 * Crawl task manager
 */
public interface CrawlTaskService {

    /**
     * Get task info
     *
     * @param taskId
     * @return
     */
    CrawlTask get(Integer taskId);

    /**
     * Add crawl task
     *
     * @param crawlTask
     * @return
     */
    boolean add(CrawlTask crawlTask);

    /**
     * Delete crawl task
     *
     * @param taskId
     * @return
     */
    boolean delete(Integer taskId);

    /**
     * Get crawl tasks to bind
     * <p>
     * level       bind count  interval
     * level 1 :   5            1 min
     * level 2 :   5 - 10       2 min
     * level 3 :   10 -15       5 min
     * level 4 :   15 -20       10 min
     * other   :   *            30 min
     *
     * @param level
     * @return
     */
    List<CrawlTask> getTasksToBind(Integer level);

    /**
     * Handle bind task failed failed
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
     * Get crawl tasks( bind success) configs to dispatch
     *
     * @return
     */
    List<CrawlTaskConfig> getTasksConfigsToDispatch();

    /**
     * Handle task bind success
     *
     * @param downSystemSiteId
     * @param downSystemSiteId
     * @return
     */
    boolean dispatchSuccess(Integer taskId, Integer downSystemSiteId);

    /**
     * Handle dispatch failed
     *
     * @param dispatchFailedTask
     */
    void dispatchFailed(CrawlTask dispatchFailedTask);

    /**
     * Get execute timeout crawl tasks to terminate
     *
     * @return
     */
    List<CrawlTask> getExecuteTimeoutTasks();

    /**
     * Terminate execute timeout crawl task
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

    /**
     * Terminate bind timeout crawl task
     *
     * @param id
     */
    void terminateBindTimeoutTask(Integer id);

    /**
     * Get the tasks which over max bind time
     *
     * @return
     */
    List<CrawlTask> getBindTimeoutTasks();
}
