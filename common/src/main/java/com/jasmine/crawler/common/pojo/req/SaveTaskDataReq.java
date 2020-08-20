package com.jasmine.crawler.common.pojo.req;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaveTaskDataReq {
    private Integer downSystemId;

    private List<String> data;

    private Integer taskId;
}
