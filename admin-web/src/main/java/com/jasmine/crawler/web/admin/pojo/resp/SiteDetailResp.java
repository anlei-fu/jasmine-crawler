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
public class SiteDetailResp {

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("the name of site")
    private String name;

    @ApiModelProperty("")
    private String domain;

    @ApiModelProperty("the description of site")
    private String description;

    @ApiModelProperty("the home page url of site")
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
    private Integer loginCaptaType;

    @ApiModelProperty("need proxy")
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
    private Integer enableStatus;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("type of script")
    private Integer scriptType;

    @ApiModelProperty("label of enum")
    private String loginCaptaTypeLabel;

    @ApiModelProperty("label of enum")
    private String needUseProxyLabel;

    @ApiModelProperty("label of enum")
    private String enableStatusLabel;
}
