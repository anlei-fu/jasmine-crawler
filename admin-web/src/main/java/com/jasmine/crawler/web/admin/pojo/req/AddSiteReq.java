/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Url;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddSiteReq {

    @NotNull
    private String name;

    private String domain;

    private String description;

    @Url
    private String homePageUrl;

    private Integer parentSiteId;

    private Integer crawlNeedUseCookie;

    private Integer loginScriptId;

    private Integer loginNeedVcode;

    @Enum("loginCaptaType")
    private Integer loginCaptaType;

    @Enum("YesNo")
    private Integer needUseProxy;

    private Integer ipDelayTimeout;

    private Integer ipBlockTimeout;

    private Integer ipHourSpeedLimit;

    private Integer ipMinuteSpeedLimit;

    private Integer ipDaySpeedLimit;

    @Enum("YesNo")
    private Integer accountAllowCrossIp;

    private Integer accountAllowMultiple;

    private Integer accountMinuteSpeedLimit;

    private Integer accountHourSpeedLimit;

    private Integer accountDaySpeedLimit;

    private Integer accountMaxBlockCount;

    private Integer accountBlockTimeout;

    private Integer accountMaxCookieCount;

    private Integer accountDelayTimeout;

    private Integer cookieMaxBlockCount;

    private Integer cookieExpireTimeout;

    private Integer cookieDelayTimeout;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
