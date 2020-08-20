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
public class UpdateSiteBatchReq extends IdsFeature {

    private Integer ipMinuteSpeedLimit;

    private Integer ipHourSpeedLimit;

    private Integer ipDaySpeedLimit;

    private Integer enableStatus;

}
