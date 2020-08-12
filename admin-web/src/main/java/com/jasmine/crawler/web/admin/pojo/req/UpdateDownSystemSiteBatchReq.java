package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.pojo.req.IdsFeature;
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
public class UpdateDownSystemSiteBatchReq extends IdsFeature {
    private Integer priority;

    private Integer taskMaxRunningCount;

    private Integer taskMaxWaitToBindCount;

    private Integer taskTimeout;

    private Integer urlMaxCacheCount;

    private Integer enableStatus;
}
