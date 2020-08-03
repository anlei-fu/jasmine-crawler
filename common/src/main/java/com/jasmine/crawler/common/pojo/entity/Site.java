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

@ApiModel("site info")
@Getter
@Setter
public class Site extends CreateTimeFeature {
    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * Parent site of the site
     */
    @ApiModelProperty("the parent site of the site")
    private Integer parentSiteId;

    /**
     * Name of the site
     */
    @ApiModelProperty("the name of site")
    private String name;

    /**
     * Description of the site
     */
    @ApiModelProperty("the description of site")
    private String description;

    /**
     * Homepage url of site
     */
    @ApiModelProperty("the home page url of site")
    private String homePageUrl;

    /**
     * The script to login and get cookie
     */
    @ApiModelProperty("the login script of the site")
    private Integer loginScriptId;

    @ApiModelProperty("login need vcode")
    private Integer needLoginVcode;

    @ApiModelProperty("the captaa type of the site")
    private Integer captaType;

    /**
     * Determine if use cookie
     */
    @ApiModelProperty("need use cookie")
    private Integer needUseCookie;

    /**
     * Determine if use proxy
     */
    @ApiModelProperty("need proxy")
    private Integer needUseProxy;

    /**
     * Determine  which region proxy suit for the site
     */
    private Integer proxyRegion;

    /**
     *
     */
    private Integer accountAllowCrossIp;

    /**
     * The max pv per account within in a day
     */
    @ApiModelProperty("")
    private Integer accountDaySpeedLimit;

    /**
     * The max pv per account within in an hour
     */
    @ApiModelProperty("")
    private Integer accountHourSpeedLimit;

    /**
     * The max pv per account within in one minute
     */
    @ApiModelProperty("")
    private Integer accountMinuteSpeedLimit;

    /**
     * Determine the delay of account (minute) since last task
     */
    private Integer accountDelayTimeout;

    /**
     * The block timespan (hour)
     */
    private Integer accountBlockTimeout;

    /**
     *
     */
    private Integer cookieAllowCrossIp;

    /**
     * Cookie expired timeout (hour)
     */
    @ApiModelProperty("the timeout ookie expire")
    private Integer cookieExpireTimeout;

    /**
     * The max pv per cookie within in a day
     */
    @ApiModelProperty("")
    private Integer cookieDaySpeedLimit;

    /**
     * The max pv per cookie within in an hour
     */
    @ApiModelProperty("")
    private Integer cookieHourSpeedLimit;

    /**
     * The max pv per cookie within in one minute
     */
    @ApiModelProperty("")
    private Integer cookieMinuteSpeedLimit;

    /**
     * Determine the delay of cookie since last crawl
     */
    private Integer cookieDelayTimeout;

    /**
     * How long (hour) that the ip can visit the site again since ip was blocked
     */
    @ApiModelProperty("ip block timeout when task be blocked")
    private Integer ipBlockTimeout;

    /**
     * How long that ip can visit the site again since last visit (minute)
     */
    @ApiModelProperty("ip delay timeout when crawl success")
    private Integer ipDelayTimeout;

    /**
     * The max pv per ip within in a day
     */
    @ApiModelProperty("")
    private Integer ipDaySpeedLimit;

    /**
     * The max pv per ip within in an hour
     */
    @ApiModelProperty("")
    private Integer ipHourSpeedLimit;

    /**
     * The max pv per ip within in one minute
     */
    @ApiModelProperty("")
    private Integer ipMinuteSpeedLimit;
}
