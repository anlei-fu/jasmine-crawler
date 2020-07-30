/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("crawler info")
@Getter
@Setter
public class Crawler extends EnableStatusFeature {

    /**
     * Unique id
     */
    @ApiModelProperty("the identifier of crawler")
    private Integer id;

    /**
     * The name of crawler
     */
    @ApiModelProperty("the name of crawler")
    private String name;

    /**
     * Description of crawler
     */
    @ApiModelProperty("the description of crawler")
    private String description;

    /**
     * The ip of crawler
     */
    @ApiModelProperty("the ip of crawler")
    private String ip;

    /**
     * The port of crawler rest service
     */
    @ApiModelProperty("the port of crawler")
    private Integer port;

    /**
     * Type of crawler
     */
    @ApiModelProperty("")
    private Integer crawlerType;

    /**
     * Unique key of crawler
     */
    @ApiModelProperty("the unique id of crawler")
    private String uniqueId;

    /**
     * The secret key of crawler use to validate http request, for both side
     * crawler rest service and master rest service
     */
    @ApiModelProperty("the secrete key of crawler")
    private String key;

    /**
     * The max concurrency that crawler allowed
     */
    @ApiModelProperty("the max concurrency the crawler allowed")
    private Integer maxConcurrency;

    /**
     * Current concurrency means the summary of the max concurrency of all task
     * that crawler executing
     */
    @ApiModelProperty("the current concurrency")
    private Integer currentConcurrency;

    /**
     * The heartbeat status of crawler , see HeartbeatStatus
     */
    @ApiModelProperty("")
    private Integer heartbeatStatus;

    /**
     * The last heartbeat check time
     */
    @ApiModelProperty("last heartbeat time")
    private Date lastHeartbeatTime;

    /**
     * Current heartbeat lost count means the lowest the master do heartbeat check more often
     */
    private Integer heartbeatLost;

    /**
     * Enable status
     */
    private  Integer enableStatus;

    /**
     * Create time
     */
    @ApiModelProperty("create time")
    private Date createTime;

}
