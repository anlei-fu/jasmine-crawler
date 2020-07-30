/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("proxy info")
@Getter
@Setter
public class Proxy extends EnableStatusFeature {

    /**
     * The account of proxy
     */
    @ApiModelProperty("the account of the proxy")
    private String account;

    /**
     * Create time
     */
    @ApiModelProperty("create time")
    private Date createTime;

    /**
     * The count of task using the proxy
     */
    @ApiModelProperty("the current use count of proxy")
    private Integer currentUseCount;

    /**
     * Enable status see {@enum EnableStatus}
     */
    @ApiModelProperty("enable status")
    private Integer enableStatus;

    /**
     * Unique id
     */
    @ApiModelProperty("identifier")
    private Integer id;

    /**
     * The ip of the proxy
     */
    @ApiModelProperty("the hos:port of proxy server")
    private String ip;

    /**
     * The count that how many task can use the proxy conteousely
     */
    @ApiModelProperty("the max use count of proxy")
    private Integer maxUseCount;

    /**
     * The password of account
     */
    @ApiModelProperty("the password of the proxy")
    private String password;

    /**
     * The port of proxy
     */
    @ApiModelProperty("")
    private Integer port;

    /**
     * The protocol of proxy see {@enum ProxyProtocol}
     */
    @ApiModelProperty("the protocol that proxy used")
    private String protocol;

    /**
     * The proxy type of proxy
     */
    @ApiModelProperty("the type of proxy")
    private Integer proxyType;

}
