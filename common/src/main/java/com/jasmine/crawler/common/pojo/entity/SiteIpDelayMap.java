package com.jasmine.crawler.common.pojo.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
public class SiteIpDelayMap {
    private Integer siteId;

    private  String ip;

    private Date delayTimeout;
}
