/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.PageTimeReq;
import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetSitePageReq extends PageTimeReq {

    private Integer parentSiteId;

    private Integer loginScriptId;

    @Enum("loginCaptaType")
    private Integer loginCaptaType;

    @Enum("YesNo")
    private Integer needUseProxy;

    @Enum("EnableStatus")
    private Integer enableStatus;

    @Enum("YesNo")
    private Integer needUseCookie;

    private String name;

    private String domain;

}
