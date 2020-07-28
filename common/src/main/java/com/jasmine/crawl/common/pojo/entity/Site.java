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

    /**
     * The max pv per account a day
     */
    @ApiModelProperty("")
    private Integer accountDaySpeedLimit;

    /**
     * The max pv per account an hour
     */
    @ApiModelProperty("")
    private Integer accountHourSpeedLimit;

    /**
     * The max pv per account one minute
     */
    @ApiModelProperty("")
    private Integer accountMinuteSpeedLimit;

    /**
     * Allow account cookie use on diffrent ip ,see {@enum EnableStatus}
     */
    @ApiModelProperty("")
    private Integer allowAccountCrossIp;

    /**
     *
     */
    @ApiModelProperty("allow use an account multiple times")
    private Integer allowUseAccountMultiple;

    @ApiModelProperty("the captaa type of the site")
    private Integer captaType;

    /**
     * Cookie timeout
     */
    @ApiModelProperty("the timeout ookie expire")
    private Integer cookieExpireTimeout;

    /**
     * Crawl type, see {@enum CrawlType}
     */
    @ApiModelProperty("crawl type")
    private Integer crawlType;

    /**
     * Create time
     */
    @ApiModelProperty("create time")
    private Date createTime;

    /**
     * The max pv of site
     */
    @ApiModelProperty("")
    private Integer daySpeedLimit;

    /**
     * The description of site
     */
    @ApiModelProperty("the description of site")
    private String description;

    /**
     * The homepage url of site
     */
    @ApiModelProperty("the home page url of site")
    private String homePageUrl;

    /**
     * Max pv of site per one hour
     */
    @ApiModelProperty("")
    private Integer hourSpeedLimit;

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * How long that the ip can visit site again since ip was blocked
     */
    @ApiModelProperty("ip block timeout when task be blocked")
    private Integer ipBlockTimeout;

    /**
     * How long that ip can visit the site again since last visit
     */
    @ApiModelProperty("ip delay timeout when crawl success")
    private Integer ipDelayTimeout;

    /**
     * Login script id
     */
    @ApiModelProperty("the login script of the site")
    private Integer loginScriptId;

    /**
     *
     */
    @ApiModelProperty("")
    private Integer miniteSpeedLimit;

    /**
     * The name of the site
     */
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
