package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSiteBatchReq extends IdsFeature {

    private Integer ipMinuteSpeedLimit;

    private Integer ip10MinuteSpeedLimit;

    private Integer ipHourSpeedLimit;

    private Integer ipDaySpeedLimit;

    private Integer enableStatus;

}
