package com.jasmine.crawler.common.pojo.req;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaveTaskResultReq {
    private Integer taskId;

    private Integer taskResult;

    private String msg;

    private Integer urlTotal;

    private List<PageResult> pageResults;

    private Integer averageSpeedOfSuccess;

    private Integer averageSpeedOfAll;

    private Integer medianSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;
}
