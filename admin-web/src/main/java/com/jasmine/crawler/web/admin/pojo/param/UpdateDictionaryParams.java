/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateDictionaryReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateDictionaryParams {

    @Getter @Setter private Integer id;

    @Getter @Setter private String lastUpdateUser;

    private UpdateDictionaryReq req;

    public UpdateDictionaryParams(Integer id, String lastUpdateUser, UpdateDictionaryReq req) {
        this.id = id;
        this.lastUpdateUser = lastUpdateUser;
        this.req = req;
    }

    public String getType() {
        return req.getType();
    }

    public Integer getValue() {
        return req.getValue();
    }

    public String getLabel() {
        return req.getLabel();
    }
}
