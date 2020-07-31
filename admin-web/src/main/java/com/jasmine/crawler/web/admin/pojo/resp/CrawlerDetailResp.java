/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class CrawlerDetailResp {

    @ApiModelProperty("the identifier of crawler")
    private Integer id;

    @ApiModelProperty("")
    private Integer clientVersion;

    @ApiModelProperty("the name of crawler")
    private String name;

    @ApiModelProperty("the ip of crawler")
    private String ip;

    @ApiModelProperty("the description of crawler")
    private String description;

    @ApiModelProperty("")
    private Integer crawlerType;

    @ApiModelProperty("the secrete key of crawler")
    private String key;

    @ApiModelProperty("the unique id of crawler")
    private String uniqueId;

    @ApiModelProperty("the port of crawler")
    private Integer port;

    @ApiModelProperty("the max concurrency the crawler allowed")
    private Integer maxConcurrency;

    @ApiModelProperty("the current concurrency")
    private Integer currentConcurrency;

    @ApiModelProperty("")
    private Integer heartbeatStatus;

    @ApiModelProperty("last heartbeat time")
    private Date heartbeatLastTime;

    @ApiModelProperty("")
    private Integer heartbeatLostCount;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("label of enum")
    private String crawlerTypeLabel;

    @ApiModelProperty("label of enum")
    private String heartbeatStatusLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
