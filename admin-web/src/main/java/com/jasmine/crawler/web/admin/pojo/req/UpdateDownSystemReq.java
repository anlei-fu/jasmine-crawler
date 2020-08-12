/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Url;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDownSystemReq {

    private String name;

    private Integer priority;

    private String description;

    private String appKey;

    private String appSecret;

    @Url
    private String dataUrl;

    private String dataQueue;

    private Integer taskMaxRunningCount;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
