/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.service;

import com.jasmine.crawler.common.pojo.entity.BindRecord;

/**
 * Record bind result
 */
public interface BindRecordService {

    /**
     * Add bind record happen after bind
     *
     * @param record
     */
    void add(BindRecord record);
}
