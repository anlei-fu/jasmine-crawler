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

@ApiModel("site-url-block-rule")
@Getter
@Setter
public class SiteUrlCheckRule extends  EnableStatusFeature {

    @ApiModelProperty("checkTyp: json array")
    private Integer checkType;

    @ApiModelProperty("")
    private Date createTime;

    @ApiModelProperty("description of the rul")
    private String description;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("http status code")
    private Integer httpStatus;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("json array of string to match")
    private String keywords;

    @ApiModelProperty("if match the page result returned")
    private Integer pageResultType;

    @ApiModelProperty("site the rule belong to")
    private Integer siteId;

}
