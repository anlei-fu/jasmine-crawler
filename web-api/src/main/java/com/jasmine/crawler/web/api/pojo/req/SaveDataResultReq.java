package com.jasmine.crawler.web.api.pojo.req;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaveDataResultReq {
    private Integer downSystemId;

    private List<String> data;

    private Integer taskId;
}
