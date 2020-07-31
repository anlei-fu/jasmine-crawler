/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSystemAlarmReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateSystemAlarmParams {

    @Getter @Setter private Integer id;

    private UpdateSystemAlarmReq req;

    public UpdateSystemAlarmParams(Integer id, UpdateSystemAlarmReq req) {
        this.id = id;
        this.req = req;
    }

    public String getSiteId() {
        return req.getSiteId();
    }

    public String getMsg() {
        return req.getMsg();
    }

    public Integer getIsReaded() {
        return req.getIsReaded();
    }
}
