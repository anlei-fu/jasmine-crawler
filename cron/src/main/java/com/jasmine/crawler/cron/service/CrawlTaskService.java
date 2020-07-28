/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.cron.pojo.config.CrawlTaskConfig;
import com.jasmine.crawl.common.pojo.entity.CrawlTask;

import java.util.List;

/**
 * Crawl task manager
 */
public interface CrawlTaskService {

    /**
     * Get crawl tasks to bind
     * 
     * @param level
     * @return
     */
    List<CrawlTask> getTasksToBind(Integer level);

    /**
     * Delete crawl task by id
     * 
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * Update crawl task to bind
     * 
     * @param id
     * @param updateCrawlTaskReq
     * @return
     */
    boolean update(Integer id, CrawlTask updateCrawlTaskReq);

    /**
     * Add crawl task
     * 
     * @param taskToCreate
     * @return
     */
    boolean add(CrawlTask taskToCreate);

    /**
     * Get crawl tasks config to dispatch 
     * 
     * @return
     */
    List<CrawlTaskConfig> getTasksConfigsToDispatch();

    /**
     * Get timeout crawl tasks to terminate
     * 
     * @return
     */
    List<CrawlTask> getTimeoutTasksToTerminate();

    /**
     * Handle bind failed 
     * 
     * @param taskToUpdate
     */
    void bindFailed( CrawlTask taskToUpdate);

    /**
     * Handle bind success
     * 
     * @param crawlTaskToUpdate
     * @return
     */
    boolean bindSuccess(CrawlTask crawlTaskToUpdate);

    /**
     * Terminate timeout crawl task
     * 
     * @param id
     * @param timeout
     */
    void terminateTimeoutTask(Integer id, Integer timeout);
}
