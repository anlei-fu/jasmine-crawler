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

@ApiModel("proxy info")
@Getter
@Setter
public class Proxy extends  EnableStatusFeature {

    @ApiModelProperty("the account of the proxy")
    private String account;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("the current use count of proxy")
    private Integer currentUseCount;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("identifier")
    private Integer id;

    @ApiModelProperty("the hos:port of proxy server")
    private String ip;

    @ApiModelProperty("the max use count of proxy")
    private Integer maxUseCount;

    @ApiModelProperty("the password of the proxy")
    private String password;

    @ApiModelProperty("")
    private Integer port;

    @ApiModelProperty("the protocol that proxy used")
    private String protocol;

    @ApiModelProperty("the type of proxy")
    private Integer proxyType;

}
