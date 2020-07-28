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

@ApiModel("")
@Getter
@Setter
public class Cookie extends EnableStatusFeature  {

    @ApiModelProperty("")
    private Integer accountId;

    @ApiModelProperty("")
    private String cookie;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("")
    private Integer currentUseCount;

}
