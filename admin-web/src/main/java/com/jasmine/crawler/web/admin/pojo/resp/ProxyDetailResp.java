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
public class ProxyDetailResp {

    @ApiModelProperty("identifier")
    private Integer id;

    @ApiModelProperty("the hos:port of proxy server")
    private String ip;

    @ApiModelProperty("")
    private Integer port;

    @ApiModelProperty("the account of the proxy")
    private String account;

    @ApiModelProperty("the password of the proxy")
    private String password;

    @ApiModelProperty("the protocol that proxy used")
    private String protocol;

    @ApiModelProperty("the type of proxy")
    private Integer proxyType;

    @ApiModelProperty("the max use count of proxy")
    private Integer maxUseCount;

    @ApiModelProperty("the current use count of proxy")
    private Integer currentUseCount;

    @ApiModelProperty("")
    private Integer blockMaxCount;

    @ApiModelProperty("")
    private Integer blockCurrentCount;

    @ApiModelProperty("")
    private Date blockTimeout;

    @ApiModelProperty("enable status")
    private Integer enableStatus;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("label of enum")
    private String proxyTypeLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
