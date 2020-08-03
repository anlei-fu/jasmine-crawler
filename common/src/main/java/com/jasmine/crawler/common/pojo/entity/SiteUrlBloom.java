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

@ApiModel("site-url bloom  ")
@Getter
@Setter
public class SiteUrlBloom extends CreateTimeFeature {

    /**
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * The down system site the bloom belong to
     */
    @ApiModelProperty("")
    private Integer downSystemSiteId;

    /**
     * The bloom in base64 format
     */
    @ApiModelProperty("")
    private String bloom;

    /**
     * The load status of the bloom
     */
    @ApiModelProperty("")
    private Integer bloomLoadStatus;

    /**
     * The total unique url count of the bloom
     */
    @ApiModelProperty("")
    private Integer totalCount;

    /**
     * The last load time of bloom
     */
    @ApiModelProperty("")
    private Date lastLoadTime;

    /**
     * The last dump of the bloom
     */
    @ApiModelProperty("")
    private Date lastDumpTime;

}
