package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
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
public class UpdateSiteAccountBatchReq extends IdsFeature {
    private Integer enableStatus;

    private String password;
}
