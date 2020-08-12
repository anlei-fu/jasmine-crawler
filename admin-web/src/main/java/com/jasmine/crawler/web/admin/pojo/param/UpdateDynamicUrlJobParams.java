/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateDynamicUrlJobReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UpdateDynamicUrlJobParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateDynamicUrlJobReq req;

    public UpdateDynamicUrlJobParams(Integer id, UpdateDynamicUrlJobReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getDownSystemId() {
        return req.getDownSystemId();
    }

    public Integer getScriptId() {
        return req.getScriptId();
    }

    public Integer getDynamicType() {
        return req.getDynamicType();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }

    public Integer getDelayTimeout() {
        return req.getDelayTimeout();
    }

    public Date getLastRunTime() {
        return req.getLastRunTime();
    }

    public Integer getConcurrency() {
        return req.getConcurrency();
    }

    public Integer getMaxWaintToBindTaskCount() {
        return req.getMaxWaintToBindTaskCount();
    }
}
