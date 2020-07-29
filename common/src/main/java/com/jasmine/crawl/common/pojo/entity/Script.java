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

@ApiModel("script info")
@Getter
@Setter
public class Script extends EnableStatusFeature {

    /**
     * Create time
     */
    @ApiModelProperty("create time")
    private Date createTime;

    /**
     * Usage of the script
     */
    @ApiModelProperty("script usage")
    private String description;

    /**
     * unique id
     */
    @ApiModelProperty("i: identifier key")
    private Integer id;

    /**
     * The path of script on file server
     */
    @ApiModelProperty("script path")
    private String path;

    /**
     * The type of script see {@enum ScriptType}
     */
    @ApiModelProperty("type of script")
    private Integer scriptType;

    /**
     * The down site the proxy belong to
     */
    @ApiModelProperty("site the script belong to")
    private Integer siteId;

}
