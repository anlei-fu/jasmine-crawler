/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteUrlBloom extends CreateTimeFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The down system site the bloom belong to
     */
    private Integer downSystemSiteId;

    /**
     * The bloom in base64 format
     */
    private String bloom;

    /**
     * The load status of the bloom
     */
    private Integer bloomLoadStatus;

    /**
     * The total unique url count of the bloom
     */
    private Integer totalCount;

    /**
     * The last load time of bloom
     */
    private Date lastLoadTime;

    /**
     * The last dump of the bloom
     */
    private Date lastDumpTime;

}
