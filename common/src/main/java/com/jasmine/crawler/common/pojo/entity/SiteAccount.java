/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@ApiModel("site account info")
@Getter
@Setter
public class SiteAccount extends EnableStatusFeature {

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * Nick name
     */
    @ApiModelProperty("")
    private String nickName;

    /**
     * Description of account
     */
    @ApiModelProperty("description  of account")
    private String description;

    /**
     * Login type
     */
    @ApiModelProperty("")
    private Integer loginType;

    /**
     * The site that account belong to
     */
    @ApiModelProperty("the site that account belong")
    private Integer siteId;

    /**
     * The phone of account
     */
    @ApiModelProperty("the phone of account")
    private String phone;

    /**
     * The email of account
     */
    @ApiModelProperty("the email of account")
    private String email;

    /**
     * The password of account
     */
    @ApiModelProperty("the password of account")
    private String password;

    /**
     * Last login time
     */
    @ApiModelProperty("the time that account last login")
    private Date lastLoginTime;

    /**
     * Last login ip
     */
    @ApiModelProperty("the ip that the account last login")
    private String lastLoginIp;

    /**
     * How many task is using the cookie of the account
     */
    @ApiModelProperty("the current use count of the account ")
    private Integer currentUseCount;

    /**
     * The count of account which has been blocked by site ,means the task the cookie of
     * the account has failed
     */
    @ApiModelProperty("")
    private Integer blockCurrentCount;

    /**
     * The available time of account
     */
    @ApiModelProperty("")
    private Date blockTimeoutTime;

}
