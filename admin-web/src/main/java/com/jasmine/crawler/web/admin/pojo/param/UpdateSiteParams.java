/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateSiteReq req;

    public UpdateSiteParams(Integer id, UpdateSiteReq req) {
        this.id = id;
        this.req = req;
    }

    public String getName() {
        return req.getName();
    }

    public String getDomain() {
        return req.getDomain();
    }

    public String getDescription() {
        return req.getDescription();
    }

    public String getHomePageUrl() {
        return req.getHomePageUrl();
    }

    public Integer getParentSiteId() {
        return req.getParentSiteId();
    }

    public Integer getCrawlNeedUseCookie() {
        return req.getCrawlNeedUseCookie();
    }

    public Integer getLoginScriptId() {
        return req.getLoginScriptId();
    }

    public Integer getLoginNeedVcode() {
        return req.getLoginNeedVcode();
    }

    public Integer getLoginCaptaType() {
        return req.getLoginCaptaType();
    }

    public Integer getNeedUseProxy() {
        return req.getNeedUseProxy();
    }

    public Integer getIpDelayTimeout() {
        return req.getIpDelayTimeout();
    }

    public Integer getIpBlockTimeout() {
        return req.getIpBlockTimeout();
    }

    public Integer getIpHourSpeedLimit() {
        return req.getIpHourSpeedLimit();
    }

    public Integer getIpMinuteSpeedLimit() {
        return req.getIpMinuteSpeedLimit();
    }

    public Integer getIpDaySpeedLimit() {
        return req.getIpDaySpeedLimit();
    }

    public Integer getAccountAllowCrossIp() {
        return req.getAccountAllowCrossIp();
    }

    public Integer getAccountAllowMultiple() {
        return req.getAccountAllowMultiple();
    }

    public Integer getAccountMinuteSpeedLimit() {
        return req.getAccountMinuteSpeedLimit();
    }

    public Integer getAccountHourSpeedLimit() {
        return req.getAccountHourSpeedLimit();
    }

    public Integer getAccountDaySpeedLimit() {
        return req.getAccountDaySpeedLimit();
    }

    public Integer getAccountMaxBlockCount() {
        return req.getAccountMaxBlockCount();
    }

    public Integer getAccountBlockTimeout() {
        return req.getAccountBlockTimeout();
    }

    public Integer getAccountMaxCookieCount() {
        return req.getAccountMaxCookieCount();
    }

    public Integer getAccountDelayTimeout() {
        return req.getAccountDelayTimeout();
    }

    public Integer getCookieMaxBlockCount() {
        return req.getCookieMaxBlockCount();
    }

    public Integer getCookieExpireTimeout() {
        return req.getCookieExpireTimeout();
    }

    public Integer getCookieDelayTimeout() {
        return req.getCookieDelayTimeout();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
