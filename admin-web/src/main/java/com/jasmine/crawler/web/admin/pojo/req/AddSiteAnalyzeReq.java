/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddSiteAnalyzeReq {

    @NotNull
    private Integer siteId;

    private Integer totalCount;

    private Integer successCount;

    private Integer successAverageSpeed;

    private Integer averageSpeed;

    private Integer blockIpCount;

    private Integer blockAccountCount;

    private Integer successMean;
}
