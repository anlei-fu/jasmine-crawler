/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-28 4:23:10 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateSiteBlockRuleReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateSiteBlockRuleParams {

    @Getter @Setter private Integer id;

    private UpdateSiteBlockRuleReq req;

    public UpdateSiteBlockRuleParams(Integer id, UpdateSiteBlockRuleReq req) {
        this.id = id;
        this.req = req;
    }

    public String getDescription() {
        return req.getDescription();
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public Integer getHttpStatus() {
        return req.getHttpStatus();
    }

    public Integer getCheckType() {
        return req.getCheckType();
    }

    public String getKeywords() {
        return req.getKeywords();
    }

    public Integer getPageResultType() {
        return req.getPageResultType();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
