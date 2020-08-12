/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteAnalyzeReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteAnalyzeParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateSiteAnalyzeReq req;

    public UpdateSiteAnalyzeParams(Integer id, UpdateSiteAnalyzeReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public Integer getTotalCount() {
        return req.getTotalCount();
    }

    public Integer getSuccessCount() {
        return req.getSuccessCount();
    }

    public Integer getSuccessAverageSpeed() {
        return req.getSuccessAverageSpeed();
    }

    public Integer getAverageSpeed() {
        return req.getAverageSpeed();
    }

    public Integer getBlockIpCount() {
        return req.getBlockIpCount();
    }

    public Integer getBlockAccountCount() {
        return req.getBlockAccountCount();
    }

    public Integer getSuccessMean() {
        return req.getSuccessMean();
    }
}
