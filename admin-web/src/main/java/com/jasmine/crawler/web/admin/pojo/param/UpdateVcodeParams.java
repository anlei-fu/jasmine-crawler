/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateVcodeReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateVcodeParams {

    @Getter @Setter private Integer id;

    private UpdateVcodeReq req;

    public UpdateVcodeParams(Integer id, UpdateVcodeReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getAccountId() {
        return req.getAccountId();
    }

    public Integer getVcodeType() {
        return req.getVcodeType();
    }

    public String getContent() {
        return req.getContent();
    }
}
