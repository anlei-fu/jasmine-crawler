/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Crawler extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The name of crawler
     */
    private String name;

    private String clientVersion;

    /**
     * Th description of the crawler
     */
    private String description;

    /**
     * The ip of the crawler
     */
    private String ip;

    /**
     * The port of crawler to host rest service
     */
    private Integer port;

    /**
     * Type of the crawler
     */
    private Integer crawlerType;

    /**
     * Unique key of crawler
     */
    private String uniqueId;

    /**
     * The secret key of crawler use to validate http request, for both side
     * crawler rest service and master rest service
     */
    private String key;

    /**
     * The max concurrency(crawl task count per minute) that crawler allowed
     */
    private Integer maxConcurrency;

    /**
     * Current concurrency means the summary of the max concurrency of all task
     * that crawler executing
     */
    private Integer currentConcurrency;

    /**
     * The heartbeat status of crawler , see HeartbeatStatus
     */
    private Integer heartbeatStatus;

    /**
     * The last heartbeat check time
     */
    private Date lastHeartbeatTime;

    /**
     * Current heartbeat lost count, use to determine the frequency of heartbeat checking
     * the lower the master do heartbeat check more often
     */
    private Integer heartbeatLost;
}
