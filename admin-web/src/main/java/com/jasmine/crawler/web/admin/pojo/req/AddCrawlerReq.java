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
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddCrawlerReq {

    @ApiModelProperty("")
    @NotNull
    private Integer clientVersion;

    @ApiModelProperty("the name of crawler")
    @NotNull
    private String name;

    @ApiModelProperty("the ip of crawler")
    @NotNull
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
    @NotNull
    private String uniqueId;

    @ApiModelProperty("the port of crawler")
    @NotNull
    private Integer port;

    @ApiModelProperty("the max concurrency the crawler allowed")
    private Integer maxConcurrency;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;
}
