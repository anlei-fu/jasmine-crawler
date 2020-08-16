/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateProxyReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class UpdateProxyParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateProxyReq req;

    public UpdateProxyParams(Integer id, UpdateProxyReq req) {
        this.id = id;
        this.req = req;
    }

    public String getIp() {
        return req.getIp();
    }

    public Integer getPort() {
        return req.getPort();
    }

    public String getAccount() {
        return req.getAccount();
    }

    public String getPassword() {
        return req.getPassword();
    }

    public Integer getProxyProtocol() {
        return req.getProxyProtocol();
    }

    public Integer getProxyType() {
        return req.getProxyType();
    }

    public Integer getMaxUseCount() {
        return req.getMaxUseCount();
    }

    public Integer getBlockMaxCount() {
        return req.getBlockMaxCount();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }

    public Date getBlockTimeoutTime() {
        return req.getBlockTimeoutTime();
    }
}
