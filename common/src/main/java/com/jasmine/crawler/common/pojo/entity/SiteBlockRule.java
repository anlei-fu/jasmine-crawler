/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteBlockRule extends EnableStatusFeature {

    /***
     * Unique id
     */
    private Integer id;

    /**
     * Description of the rule
     */
    private String description;

    /**
     * The site rule belong to
     */
    private Integer downSystemSiteId;

    /**
     * Http status code of the rule
     */
    private Integer httpStatus;

    /**
     * Check type of the rule see {@enum CheckType}
     */
    private Integer checkType;

    /**
     * The keywords of the rule in json array format
     */
    private String keywords;

    /**
     * The page result if match the rule see {@enum PageResult}
     */
    private Integer pageResultType;

}
