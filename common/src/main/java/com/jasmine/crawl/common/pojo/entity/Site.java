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

@ApiModel("site info")
@Getter
@Setter
public class Site  {

    @ApiModelProperty("")
    private Integer accountDaySpeedLimit;

    @ApiModelProperty("")
    private Integer accountHourSpeedLimit;

    @ApiModelProperty("")
    private Integer accountMinuteSpeedLimit;

    @ApiModelProperty("")
    private Integer allowAccountCrossIp;

    @ApiModelProperty("allow use an account multiple times")
    private Integer allowUseAccountMultiple;

    @ApiModelProperty("the captaa type of the site")
    private Integer captaType;

    @ApiModelProperty("the timeout ookie expire")
    private Integer cookieExpireTimeout;

    @ApiModelProperty("crawl type")
    private Integer crawlType;

    @ApiModelProperty("create time")
    private Date createTime;

    @ApiModelProperty("")
    private Integer daySpeedLimit;

    @ApiModelProperty("the description of site")
    private String description;

    @ApiModelProperty("the home page url of site")
    private String homePageUrl;

    @ApiModelProperty("")
    private Integer hourSpeedLimit;

    @ApiModelProperty("")
    private Integer id;

    @ApiModelProperty("ip block timeout when task be blocked")
    private Integer ipBlockTimeout;

    @ApiModelProperty("ip delay timeout when crawl success")
    private Integer ipDelayTimeout;

    @ApiModelProperty("the login script of the site")
    private Integer loginScriptId;

    @ApiModelProperty("")
    private Integer miniteSpeedLimit;

    @ApiModelProperty("the name of site")
    private String name;

    @ApiModelProperty("login need vcode")
    private Integer needLoginVcode;

    @ApiModelProperty("need use cookie")
    private Integer needUseCookie;

    @ApiModelProperty("need proxy")
    private Integer needUseProxy;

    @ApiModelProperty("the parent site of the site")
    private Integer parentSiteId;

    @ApiModelProperty("url max retry count")
    private Integer urlMaxRetryCount;

    private Integer maxConcurrency;

    private  Integer currentConcurrency;

    private  Integer taskBatchCount;

    private Integer waitToRunTaskCount;

}
