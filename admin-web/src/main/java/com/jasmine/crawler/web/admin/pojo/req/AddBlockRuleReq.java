package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Data;

@Data
public class AddBlockRuleReq {

    private Integer downSystemSiteId;

    private Integer compareType;

    private Integer httpStatus;

    private Integer pageResult;

    private String keywords;
}
