package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import com.jasmine.crawler.common.validate.annotation.Enum;
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
public class UpdateDownSystemBatchReq extends IdsFeature {
    private Integer priority;

    private Integer taskMaxRunningCount;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
