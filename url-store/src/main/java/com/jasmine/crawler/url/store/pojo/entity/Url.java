package com.jasmine.crawler.url.store.pojo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
public class Url {
    private  Integer downSystemSiteId;
    private  String url;
    private  String referUrl;
    private  Integer isDynamic;
}
