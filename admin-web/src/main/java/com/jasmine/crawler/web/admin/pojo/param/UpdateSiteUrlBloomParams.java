/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteUrlBloomReq;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteUrlBloomParams {

    @Getter @Setter private Integer id;

    private UpdateSiteUrlBloomReq req;

    public UpdateSiteUrlBloomParams(Integer id, UpdateSiteUrlBloomReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getDonwSystemSiteId() {
        return req.getDonwSystemSiteId();
    }

    public String getBloom() {
        return req.getBloom();
    }

    public Integer getBloomLoadingStatus() {
        return req.getBloomLoadingStatus();
    }

    public Integer getTotalCount() {
        return req.getTotalCount();
    }

    public Date getLastLoadingTime() {
        return req.getLastLoadingTime();
    }

    public Date getLastDumpTime() {
        return req.getLastDumpTime();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
