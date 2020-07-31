/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.web.admin.validate.annotation.Enum;
import com.jasmine.crawler.web.admin.validate.annotation.Url;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@ApiModel("")
@Getter
@Setter
public class AddSiteReq {

    @ApiModelProperty("the name of site")
    @NotNull
    private String name;

    @ApiModelProperty("")
    @Url
    private String domain;

    @ApiModelProperty("the description of site")
    private String description;

    @ApiModelProperty("the home page url of site")
    @NotNull
    @Url
    private String homePageUrl;

    @ApiModelProperty("the parent site of the site")
    private Integer parentSiteId;

    @ApiModelProperty("need use cookie")
    private Integer crawlNeedUseCookie;

    @ApiModelProperty("the login script of the site")
    private Integer loginScriptId;

    @ApiModelProperty("login need vcode")
    private Integer loginNeedVcode;

    @ApiModelProperty("the captaa type of the site")
    @Enum("loginCaptaType")
    private Integer loginCaptaType;

    @ApiModelProperty("need proxy")
    @Enum("booleanFlag")
    private Integer needUseProxy;

    @ApiModelProperty("ip delay timeout when crawl success")
    private Integer ipDelayTimeout;

    @ApiModelProperty("ip block timeout when task be blocked")
    private Integer ipBlockTimeout;

    @ApiModelProperty("")
    private Integer ipHourSpeedLimit;

    @ApiModelProperty("")
    private Integer ipMinuteSpeedLimit;

    @ApiModelProperty("")
    private Integer ipDaySpeedLimit;

    @ApiModelProperty("")
    private Integer accountAllowCrossIp;

    @ApiModelProperty("allow use an account multiple times")
    private Integer accountAllowMultiple;

    @ApiModelProperty("")
    private Integer accountMinuteSpeedLimit;

    @ApiModelProperty("")
    private Integer accountHourSpeedLimit;

    @ApiModelProperty("")
    private Integer accountDaySpeedLimit;

    @ApiModelProperty("")
    private Integer accountMaxBlockCount;

    @ApiModelProperty("")
    private Integer accountBlockTimeout;

    @ApiModelProperty("")
    @NotNull
    private Integer accountMaxCookieCount;

    @ApiModelProperty("")
    private Integer accountDelayTimeout;

    @ApiModelProperty("")
    private Integer cookieMaxBlockCount;

    @ApiModelProperty("the timeout ookie expire")
    private Integer cookieExpireTimeout;

    @ApiModelProperty("")
    private Integer cookieDelayTimeout;

    @ApiModelProperty("")
    @Enum("enableStatus")
    private Integer enableStatus;
}
