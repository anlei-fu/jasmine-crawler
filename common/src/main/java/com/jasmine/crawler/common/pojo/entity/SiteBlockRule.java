/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("site-url-block-rule")
@Getter
@Setter
public class SiteBlockRule extends EnableStatusFeature {

    /***
     * Unique id
     */
    @ApiModelProperty("")
    private Integer id;

    /**
     * Description of the rule
     */
    @ApiModelProperty("description of the rul")
    private String description;

    /**
     * The site rule belong to
     */
    @ApiModelProperty("site the rule belong to")
    private Integer downSystemSiteId;

    /**
     * Http status code of the rule
     */
    @ApiModelProperty("http status code")
    private Integer httpStatus;

    /**
     * Check type of the rule see {@enum CheckType}
     */
    @ApiModelProperty("checkTyp: json array")
    private Integer checkType;

    /**
     * The keywords of the rule in json array format
     */
    @ApiModelProperty("json array of string to match")
    private String keywords;

    /**
     * The page result if match the rule see {@enum PageResult}
     */
    @ApiModelProperty("if match the page result returned")
    private Integer pageResultType;

}
