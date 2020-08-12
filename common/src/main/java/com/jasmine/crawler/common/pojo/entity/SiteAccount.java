/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SiteAccount extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * Account
     */
    private String account;

    /**
     * Mark the account is validated
     */
    private Integer validated;

    /**
     * The type of account see {@enum AccountType}
     */
    private Integer AccountType;

    /**
     * Nick name
     */
    private String nickName;

    /**
     * Description of account
     */
    private String description;

    /**
     * Login type
     */
    private Integer loginType;

    /**
     * The site that account belong to
     */
    private Integer siteId;

    /**
     * The phone of account
     */
    private String phone;

    /**
     * The email of account
     */
    private String email;

    /**
     * The password of account
     */
    private String password;

    /**
     * Last login time
     */
    private Date lastLoginTime;

    /**
     * Last login ip
     */
    private String lastLoginIp;

    /**
     * How many task is using the cookie of the account
     */
    private Integer currentUseCount;

    /**
     * The count of account which has been blocked by site ,means the task the cookie of
     * the account has failed
     */
    private Integer blockCurrentCount;

    /**
     * The available time after blocked
     */
    private Date blockTimeoutTime;

    /**
     * The available time after delayed
     */
    private Date delayTimeoutTime;

}
