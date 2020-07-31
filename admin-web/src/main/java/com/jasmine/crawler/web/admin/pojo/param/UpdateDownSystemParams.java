/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateDownSystemParams {

    @Getter @Setter private Integer id;

    private UpdateDownSystemReq req;

    public UpdateDownSystemParams(Integer id, UpdateDownSystemReq req) {
        this.id = id;
        this.req = req;
    }

    public String getName() {
        return req.getName();
    }

    public Integer getPriority() {
        return req.getPriority();
    }

    public String getDescription() {
        return req.getDescription();
    }

    public String getAppKey() {
        return req.getAppKey();
    }

    public String getAppSecret() {
        return req.getAppSecret();
    }

    public String getDataUrl() {
        return req.getDataUrl();
    }

    public String getDataQueue() {
        return req.getDataQueue();
    }

    public Integer getTaskMaxRunningCount() {
        return req.getTaskMaxRunningCount();
    }

    public Integer getTaskCurrentRunningCount() {
        return req.getTaskCurrentRunningCount();
    }

    public Integer getUrlTotalCount() {
        return req.getUrlTotalCount();
    }

    public Integer getUrlFinishedCount() {
        return req.getUrlFinishedCount();
    }

    public Integer getUrlBadCount() {
        return req.getUrlBadCount();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
