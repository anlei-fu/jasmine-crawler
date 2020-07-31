/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteIpBlockMapReq;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteIpBlockMapParams {

    @Getter @Setter private Integer id;

    private UpdateSiteIpBlockMapReq req;

    public UpdateSiteIpBlockMapParams(Integer id, UpdateSiteIpBlockMapReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public String getIp() {
        return req.getIp();
    }

    public Date getBlockTimeout() {
        return req.getBlockTimeout();
    }
}
