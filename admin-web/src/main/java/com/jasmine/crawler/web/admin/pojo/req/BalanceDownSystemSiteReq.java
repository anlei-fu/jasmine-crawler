package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDownSystemSiteReq {
    private  Integer downSystemSiteId;
    private  Integer runLimitMaxDays;
    private  Integer runLimitMaxHours;
}
