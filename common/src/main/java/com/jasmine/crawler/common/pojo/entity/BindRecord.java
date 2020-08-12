/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-25 2:58:14 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BindRecord {
    /**
     * Unique id
     */
    private Integer id;

    /**
     * Task to bind
     */
    private Integer crawlTaskId;

    /**
     * Bind task result
     */
    private Integer bindResult;

    /**
     * Bind msg use to record bind failed reason or success info
     */
    private String bindMsg;

    /**
     * Create time
     */
    private Date createTime;

}
