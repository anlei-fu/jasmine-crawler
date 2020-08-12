/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateUrlReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateParams {

    @Getter
    @Setter
    private String url;

    private UpdateUrlReq req;

    public UpdateParams(String url, UpdateUrlReq req) {
        this.url = url;
        this.req = req;
    }

    public Integer getDepth() {
        return req.getDepth();
    }

    public Integer getDownSystemSiteId() {
        return req.getDownSystemSiteId();
    }

    public Integer getUrlType() {
        return req.getUrlType();
    }

    public String getReferUrl() {
        return req.getReferUrl();
    }

    public Integer getCrawlCount() {
        return req.getCrawlCount();
    }

    public Integer getUrlStatus() {
        return req.getUrlStatus();
    }

    public String getLastCrawlTime() {
        return req.getLastCrawlTime();
    }

    public String getQueryString() {
        return req.getQueryString();
    }
}
