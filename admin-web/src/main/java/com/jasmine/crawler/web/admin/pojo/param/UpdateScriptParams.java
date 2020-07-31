/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateScriptReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateScriptParams {

    @Getter @Setter private Integer id;

    private UpdateScriptReq req;

    public UpdateScriptParams(Integer id, UpdateScriptReq req) {
        this.id = id;
        this.req = req;
    }

    public String getDescription() {
        return req.getDescription();
    }

    public String getPath() {
        return req.getPath();
    }

    public Integer getScriptType() {
        return req.getScriptType();
    }

    public Integer getDownSiteId() {
        return req.getDownSiteId();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
