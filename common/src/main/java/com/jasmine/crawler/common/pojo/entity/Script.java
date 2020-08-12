/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Script extends EnableStatusFeature {

    /**
     * unique id
     */
    private Integer id;

    private Integer downSystemSiteId;

    private Integer siteId;

    /**
     * Usage of the script
     */
    private String description;

    /**
     * The type of script see {@enum ScriptType}
     */
    private Integer scriptType;

    /**
     * The path of script on file server
     */
    private String path;

    /**
     * Create time
     */
    private Date createTime;
}
