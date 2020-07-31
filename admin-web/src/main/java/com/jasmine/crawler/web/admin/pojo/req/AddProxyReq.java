/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import com.jasmine.crawler.web.admin.validate.annotation.Ip;
import com.jasmine.crawler.web.admin.validate.annotation.Password;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddProxyReq {

    @ApiModelProperty("the hos:port of proxy server")
    @NotNull
    @Ip
    private String ip;

    @ApiModelProperty("")
    @NotNull
    private Integer port;

    @ApiModelProperty("the account of the proxy")
    @NotNull
    private String account;

    @ApiModelProperty("the password of the proxy")
    @NotNull
    @Password
    private String password;

    @ApiModelProperty("the protocol that proxy used")
    @NotNull
    private String protocol;

    @ApiModelProperty("the type of proxy")
    @Enum("proxyType")
    private Integer proxyType;

    @ApiModelProperty("the max use count of proxy")
    private Integer maxUseCount;

    @ApiModelProperty("")
    @NotNull
    private Integer blockMaxCount;

    @ApiModelProperty("enable status")
    @Enum("enableStatus")
    private Integer enableStatus;
}
