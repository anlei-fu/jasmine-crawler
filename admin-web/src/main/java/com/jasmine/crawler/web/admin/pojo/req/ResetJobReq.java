package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetJobReq {
    private  Integer downSystemSiteId;

    private  Integer urlFailedRetryTimeout;
    private  Integer urlFailedRetryJobInterval;

    private Integer urlResetTimeout;
    private  Integer urlResetJobInterval;

    private  Integer urlCacheTimeout;
    private  Integer urlCacheTimeoutJobInterval;
}
