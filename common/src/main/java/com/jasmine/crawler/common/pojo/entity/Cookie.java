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

import java.util.Date;

@ApiModel("")
@Getter
@Setter
public class Cookie extends EnableStatusFeature {

    /**
     * Unique key
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * The account the cookie belong to
     */
    @ApiModelProperty("")
    private Integer accountId;

    /**
     * Cookie in json string format
     */
    @ApiModelProperty("")
    private String cookie;

    /**
     * The ip got the cookie
     */
    private String loginIp;

    /**
     * Current block count of cookie, when task failed or blocked increase it or reset to zero
     * the max block count config in {@type Site}
     */
    private Integer currentBlockCount;

    /**
     * Use to record how many task is using the cookie
     */
    @ApiModelProperty("")
    private Integer currentUseCount;

    /**
     * The expire time of the cookie
     */
    private Date expireTime;

}
