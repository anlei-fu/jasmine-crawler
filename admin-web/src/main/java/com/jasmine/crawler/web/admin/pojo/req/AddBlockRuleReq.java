package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Data;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class AddBlockRuleReq {

    private  Integer downSystemSiteId;

    private  Integer compareType;

    private  Integer httpStatus;

    private  Integer pageResult;

    private  String keywords;
}
