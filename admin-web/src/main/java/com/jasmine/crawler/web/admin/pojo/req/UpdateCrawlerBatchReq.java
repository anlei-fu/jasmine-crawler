package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import com.jasmine.crawler.common.validate.annotation.Enum;
import com.jasmine.crawler.common.validate.annotation.Ip;
import lombok.Getter;
import lombok.Setter;

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
