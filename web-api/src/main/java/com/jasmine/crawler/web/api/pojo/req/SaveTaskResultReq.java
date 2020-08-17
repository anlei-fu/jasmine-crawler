package com.jasmine.crawler.web.api.pojo.req;

import com.jasmine.crawler.common.pojo.entity.Url;
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

    private List<String> data;

    private List<Url> newUrls;

    private List<Integer> badUrls;

    private List<Integer> succeedUrls;

    private List<Integer> failedUrls;

    private List<Integer> unCrawledUrls;

    private Integer averageSpeedOfSuccess;

    private Integer averageSpeedOfAll;

    private Integer meanSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;
}