package com.jasmine.crawler.url.store.pojo.req;

import lombok.Data;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class GetUrlForTaskReq {
    private Integer downSystemSiteId;

    private Integer siteId;
}
