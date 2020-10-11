/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.AddDictionaryReq;
import lombok.Getter;
import lombok.Setter;

public class AddDictionaryParams {

    @Getter
    @Setter
    private String createUser;

    private AddDictionaryReq req;

    public AddDictionaryParams(String createUser, AddDictionaryReq req) {
        this.createUser = createUser;
        this.req = req;
    }

    public String getType() {
        return req.getType();
    }

    public String getValue() {
        return req.getValue();
    }

    public String getLabel() {
        return req.getLabel();
    }
}
