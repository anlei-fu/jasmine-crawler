/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM 
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.cron.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("script info")
@Getter
@Setter
public class Script extends  EnableStatusFeature {

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("script usage")
    private String description;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("i: identifier key")
    private Integer id;

    @ApiModelProperty("script path")
    private String path;

    @ApiModelProperty("type of script")
    private Integer scriptType;

    @ApiModelProperty("site the script belong to")
    private Integer siteId;

}
