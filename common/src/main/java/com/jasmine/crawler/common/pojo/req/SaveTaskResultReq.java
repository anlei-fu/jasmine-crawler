package com.jasmine.crawler.common.pojo.req;

import com.jasmine.crawler.common.pojo.entity.Url;
import com.jasmine.crawler.common.pojo.dto.UrlResult;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SaveTaskResultReq {
    private Integer taskId;

    private Integer taskResult;

    private String message;

    private Integer urlTotal;

    private List<UrlResult> urlResults;

    private List<Url> unCrawledUrls;

    private Integer averageSpeedOfSuccess;

    private Integer averageSpeedOfAll;

    private Integer meanSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;
}
