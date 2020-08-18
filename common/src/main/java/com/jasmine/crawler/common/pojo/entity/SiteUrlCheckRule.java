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
public class SiteUrlCheckRule extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * Description of rule
     */
    private String description;

    /**
     * Owned down system site
     */
    private Integer downSystemSiteId;

    /**
     * Target page result type see {@enum PageResult}
     */
    private Integer pageResultType;

    /**
     * The check type see {@enum CheckType}
     */
    private Integer checkType;

    /**
     * See {@enum HttpStatus}
     */
    private Integer httpStatus;

    /**
     * Json string array
     */
    private String keywords;

}
