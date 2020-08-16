/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlerReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateCrawlerParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateCrawlerReq req;

    public UpdateCrawlerParams(Integer id, UpdateCrawlerReq req) {
        this.id = id;
        this.req = req;
    }

    public String getClientVersion() {
        return req.getClientVersion();
    }

    public String getName() {
        return req.getName();
    }

    public String getIp() {
        return req.getIp();
    }

    public String getDescription() {
        return req.getDescription();
    }

    public Integer getCrawlerType() {
        return req.getCrawlerType();
    }

    public String getKey() {
        return req.getKey();
    }

    public String getUniqueId() {
        return req.getUniqueId();
    }

    public Integer getPort() {
        return req.getPort();
    }

    public Integer getMaxConcurrency() {
        return req.getMaxConcurrency();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
