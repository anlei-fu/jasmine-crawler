/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 5:12:50 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateCrawlTaskReq;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class UpdateCrawlTaskParams {

    @Getter @Setter private Integer id;

    private UpdateCrawlTaskReq req;

    public UpdateCrawlTaskParams(Integer id, UpdateCrawlTaskReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public Integer getDownSystemSiteId() {
        return req.getDownSystemSiteId();
    }

    public Date getTaskTimeoutTime() {
        return req.getTaskTimeoutTime();
    }

    public Integer getTaskStatus() {
        return req.getTaskStatus();
    }

    public Integer getTaskExecuteResultType() {
        return req.getTaskExecuteResultType();
    }

    public Integer getCrawlerId() {
        return req.getCrawlerId();
    }

    public Integer getBindLastStatus() {
        return req.getBindLastStatus();
    }

    public String getBindLastMsg() {
        return req.getBindLastMsg();
    }

    public Date getBindLastTime() {
        return req.getBindLastTime();
    }

    public Integer getBindCount() {
        return req.getBindCount();
    }

    public Integer getDispatchStatus() {
        return req.getDispatchStatus();
    }

    public Date getDispatchTime() {
        return req.getDispatchTime();
    }

    public String getDispatchMsg() {
        return req.getDispatchMsg();
    }

    public Integer getCookieId() {
        return req.getCookieId();
    }

    public String getCookie() {
        return req.getCookie();
    }

    public Integer getProxyId() {
        return req.getProxyId();
    }

    public Date getTaskStartTime() {
        return req.getTaskStartTime();
    }

    public Date getTaskFinishTime() {
        return req.getTaskFinishTime();
    }

    public Integer getSuccessUrlCount() {
        return req.getSuccessUrlCount();
    }

    public Integer getUrlFailedCount() {
        return req.getUrlFailedCount();
    }

    public Integer getUrlNewCount() {
        return req.getUrlNewCount();
    }

    public Integer getUrlBadCount() {
        return req.getUrlBadCount();
    }

    public Integer getAverageSpeedOfAll() {
        return req.getAverageSpeedOfAll();
    }

    public Integer getAverageSpeedOfSuccess() {
        return req.getAverageSpeedOfSuccess();
    }

    public Integer getMeanSpeedOfSuccess() {
        return req.getMeanSpeedOfSuccess();
    }

    public Integer getMaxSpeedOfSuccess() {
        return req.getMaxSpeedOfSuccess();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }
}
