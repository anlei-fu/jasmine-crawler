package com.jasmine.crawler.common.pojo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUrlForTaskReq {
    private Integer downSystemSiteId;
}
