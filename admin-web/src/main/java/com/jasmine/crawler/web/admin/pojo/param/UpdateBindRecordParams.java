/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateBindRecordReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateBindRecordParams {

    @Getter @Setter private Integer id;

    private UpdateBindRecordReq req;

    public UpdateBindRecordParams(Integer id, UpdateBindRecordReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getCrawlTaskId() {
        return req.getCrawlTaskId();
    }

    public String getMsg() {
        return req.getMsg();
    }

    public Integer getBindStatus() {
        return req.getBindStatus();
    }
}
