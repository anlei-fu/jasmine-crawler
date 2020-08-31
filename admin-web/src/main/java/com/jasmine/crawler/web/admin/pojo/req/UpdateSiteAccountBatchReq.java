package com.jasmine.crawler.web.admin.pojo.req;

import com.jasmine.crawler.common.api.req.IdsFeature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSiteAccountBatchReq extends IdsFeature {
    private Integer enableStatus;

    private String password;
}
