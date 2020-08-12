/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Ip;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddProxyReq {

    @NotNull
    @Ip
    private String ip;

    @NotNull
    private Integer port;

    @Enum("proxyType")
    private Integer proxyType;

    private String protocol;

    private String account;

    private String password;

    private Integer maxUseCount;

    private Integer blockMaxCount;

    private Integer blockTimeout;

    @Enum("enableStatus")
    private Integer enableStatus;
}
