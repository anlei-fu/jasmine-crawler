/*----------------------------------------------------------------------------
 * Jasmine code generator, a tool to build web crud application,with spring-
 * boot, mybatis, mysql,swagger,spring-security.
 * Generated at 2020-7-31 9:09:23 PM
 * All rights reserved by fuanlei(email:767550758@qq.com) since 2019
 *---------------------------------------------------------------------------*/
package com.jasmine.crawler.web.admin.pojo.param;

import com.jasmine.crawler.web.admin.pojo.req.UpdateDownSystemSiteReq;
import lombok.Getter;
import lombok.Setter;

public class UpdateDownSystemSiteParams {

    @Getter
    @Setter
    private Integer id;

    private UpdateDownSystemSiteReq req;

    public UpdateDownSystemSiteParams(Integer id, UpdateDownSystemSiteReq req) {
        this.id = id;
        this.req = req;
    }

    public Integer getSiteId() {
        return req.getSiteId();
    }

    public String getScriptPath() {
        return req.getScriptPath();
    }

    public Integer getDownSystemId() {
        return req.getDownSystemId();
    }

    public Integer getPriority() {
        return req.getPriority();
    }

    public String getCrawlerPageEncoding() {
        return req.getCrawlerPageEncoding();
    }

    public Integer getCrawlerPageTimeout() {
        return req.getCrawlerPageTimeout();
    }

    public Integer getCrawlerCrawlType() {
        return req.getCrawlerCrawlType();
    }

    public Integer getCrawlerAutoDownloadPage() {
        return req.getCrawlerAutoDownloadPage();
    }

    public Integer getUrlMaxCacheCount() {
        return req.getUrlMaxCacheCount();
    }

    public String getUrlEncodes() {
        return req.getUrlEncodes();
    }

    public Integer getUrlMaxCrawlCount() {
        return req.getUrlMaxCrawlCount();
    }

    public String getUrlMatchPatterns() {
        return req.getUrlMatchPatterns();
    }

    public Integer getTaskUrlBatchCount() {
        return req.getTaskUrlBatchCount();
    }

    public Integer getTaskMaxCount() {
        return req.getTaskMaxCount();
    }

    public Integer getTaskMaxRunningCount() {
        return req.getTaskMaxRunningCount();
    }

    public Integer getTaskBindTimeout() {
        return req.getTaskBindTimeout();
    }

    public Integer getTaskTimeout() {
        return req.getTaskTimeout();
    }

    public Integer getEnableStatus() {
        return req.getEnableStatus();
    }

    public Integer getBloomExpectedUrlSize() {
        return req.getBloomExpectedUrlSize();
    }

    public Integer getBloomFpp() {
        return req.getBloomFpp();
    }

    public Integer getUrlMaxDepth() {
        return req.getUrlMaxDepth();
    }

    public Integer getTaskUrlMaxFailCount() {
        return req.getTaskUrlMaxFailCount();
    }

    public Integer getTaskUrlMaxContinuouslyFailCount() {
        return req.getTaskUrlMaxContinuouslyFailCount();
    }

    public Integer getTaskUrlMaxConcurrency() {
        return req.getTaskUrlMaxConcurrency();
    }

    public String getName() {
        return req.getName();
    }

    public String getDescription() {
        return req.getDescription();
    }

    public Integer getDownSystemSiteType() {
        return req.getDownSystemSiteType();
    }

    public  Integer getRunLimitMaxDays(){
        return  req.getRunLimitMaxDays();
    }

    public  Integer getRunLimitMaxHours(){
        return  req.getRunLimitMaxHours();
    }

    public  Integer getRunLimitAllowAutoBalance(){
        return  req.getRunLimitAllowAutoBalance();
    }
}
