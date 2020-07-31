/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateDispatchTaskRecordReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateDispatchTaskRecordParams {

    @Getter @Setter private Integer id;

    private UpdateDispatchTaskRecordReq req;

    public UpdateDispatchTaskRecordParams(Integer id, UpdateDispatchTaskRecordReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getCrawlTaskId() {
        return req.getCrawlTaskId();
    }

    public Integer getDispatchStatus() {
        return req.getDispatchStatus();
    }

    public String getDispatchMsg() {
        return req.getDispatchMsg();
    }

    public String getCreateTime() {
        return req.getCreateTime();
    }
}
