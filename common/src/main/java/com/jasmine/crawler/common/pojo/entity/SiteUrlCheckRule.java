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
public class SiteUrlCheckRule extends EnableStatusFeature {

    private Integer checkType;

    private Date createTime;

    private String description;

    private Integer enableStatus;

    private Integer httpStatus;

    private Integer id;

    private String keywords;

    private Integer pageResultType;

    private Integer siteId;

}
