/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import com.jasmine.crawler.web.admin.validate.annotation.Ip;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class UpdateCrawlerReq {

    @ApiModelProperty("")
    private Integer clientVersion;

    @ApiModelProperty("the name of crawler")
    private String name;

    @ApiModelProperty("the ip of crawler")
    @Ip
    private String ip;

    @ApiModelProperty("the description of crawler")
    private String description;

    @ApiModelProperty("")
    @Enum("crawlerType")
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

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;
}
