/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawl.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("crawler info")
@Getter
@Setter
public class Crawler extends EnableStatusFeature  {

    @ApiModelProperty("")
    private Integer crawlerType;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("the current concurrency")
    private Integer currentConcurrency;

    @ApiModelProperty("the description of crawler")
    private String description;

    @ApiModelProperty("")
    private Integer endTime;

    @ApiModelProperty("the identifier of crawler")
    private Integer id;

    @ApiModelProperty("the ip of crawler")
    private String ip;

    @ApiModelProperty("the secrete key of crawler")
    private String key;

    @ApiModelProperty("")
    private Integer lastHeartbeatStatus;

    @ApiModelProperty("last heartbeat time")
    private Date lastHeartbeatTime;

    @ApiModelProperty("")
    private Integer limitRunTime;

    @ApiModelProperty("the max concurrency the crawler allowed")
    private Integer maxConcurrency;

    @ApiModelProperty("the name of crawler")
    private String name;

    @ApiModelProperty("the port of crawler")
    private Integer port;

    @ApiModelProperty("")
    private Integer startTime;

    @ApiModelProperty("the unique id of crawler")
    private String uniqueId;

    private  Integer heartbeatLost;
}
