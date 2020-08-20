package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Ip;
import lombok.Getter;
import lombok.Setter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Getter
@Setter
public class UpdateCrawlerBatchReq extends IdsFeature {

    private String clientVersion;

    private Integer maxConcurrency;

    @Ip
    private String ip;

    @Enum("EnableStatus")
    private Integer enableStatus;

    private String description;

    @Enum("CrawlerType")
    private Integer crawlerType;

}
