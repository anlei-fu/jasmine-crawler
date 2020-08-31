package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import com.jasmine.crawler.common.validate.annotation.Enum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDownSystemBatchReq extends IdsFeature {
    private Integer priority;

    private Integer taskMaxRunningCount;

    @Enum("EnableStatus")
    private Integer enableStatus;
}
