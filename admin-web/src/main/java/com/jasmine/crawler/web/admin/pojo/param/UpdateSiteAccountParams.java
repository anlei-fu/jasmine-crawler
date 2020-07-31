/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAccountReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteAccountParams {

    @Getter @Setter private Integer id;

    private UpdateSiteAccountReq req;

    public UpdateSiteAccountParams(Integer id, UpdateSiteAccountReq req) {
        this.id = id;
        this.req = req;
    }

    public String getNickName() {
        return req.getNickName();
    }

    public String getDescription() {
        return req.getDescription();
    }

    public Integer getLoginType() {
        return req.getLoginType();
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public String getPhone() {
        return req.getPhone();
    }

    public String getEmail() {
        return req.getEmail();
    }

    public String getPassword() {
        return req.getPassword();
    }

    public String getLastLoginIp() {
        return req.getLastLoginIp();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
