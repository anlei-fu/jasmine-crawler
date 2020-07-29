/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawl.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@ApiModel("")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BindRecord {

    /**
     * Bind task result
     */
    @ApiModelProperty("")
    private Integer bindStatus;

    /**
     * Task to bind
     */
    @ApiModelProperty("")
    private Integer crawlTaskId;

    /**
     * Create time
     */
    @ApiModelProperty("")
    private Date createTime;

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * Bind msg use to record bind failed reason or success info
     */
    @ApiModelProperty("")
    private String msg;

}
