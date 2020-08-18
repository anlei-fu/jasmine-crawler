/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Site extends EnableStatusFeature {
    /**
     * Unique id
     */
    private Integer id;

    /**
     * Parent site of the site
     */
    private Integer parentSiteId;

    /**
     * Name of the site
     */
    private String name;

    /**
     * Description of the site
     */
    private String description;

    /**
     * Homepage url of site
     */
    private String homePageUrl;

    /**
     * The script to login and get cookie
     */
    private Integer loginScriptId;

    private Integer needLoginVcode;

    private Integer captaType;

    /**
     * Determine if use cookie
     */
    private Integer needUseCookie;

    /**
     * Determine if use proxy
     */
    private Integer needUseProxy;

    /**
     * Determine  which region proxy suit for the site
     */
    private Integer proxyRegion;

    /**
     *
     */
    private Integer accountAllowCrossIp;

    private Integer accountAllowMultiple;

    /**
     * The max pv per account within in a day
     */
    private Integer accountDaySpeedLimit;

    /**
     * The max pv per account within in an hour
     */
    private Integer accountHourSpeedLimit;

    /**
     * The max pv per account within in one minute
     */
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
    private Integer cookieExpireTimeout;

    /**
     * The max pv per cookie within in a day
     */
    private Integer cookieDaySpeedLimit;

    /**
     * The max pv per cookie within in an hour
     */
    private Integer cookieHourSpeedLimit;

    /**
     * The max pv per cookie within in one minute
     */
    private Integer cookieMinuteSpeedLimit;

    /**
     * Determine the delay of cookie since last crawl
     */
    private Integer cookieDelayTimeout;

    /**
     * How long (hour) that the ip can visit the site again since ip was blocked
     */
    private Integer ipBlockTimeout;

    /**
     * How long that ip can visit the site again since last visit (minute)
     */
    private Integer ipDelayTimeout;

    /**
     * The max pv per ip within in a day
     */
    private Integer ipDaySpeedLimit;

    /**
     * The max pv per ip within in an hour
     */
    private Integer ipHourSpeedLimit;

    /**
     * The max pv per ip within in one minute
     */
    private Integer ipMinuteSpeedLimit;
}
