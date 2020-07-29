package com.jasmine.crawl.web.api.pojo.req;

import com.jasmine.crawl.common.pojo.entity.Url;
import lombok.Data;

import java.util.List;

@Data
public class TaskResultReq {
    private List<String> data;

    private List<Url> newUrls;

    private List<String> badUrls;

    private List<String> succeedUrls;

    private List<String> failedUrls;

    private List<String> unStartUrls;

    private Integer taskStatus;

    private Integer taskId;

    private Integer downSystemSiteId;

    private Integer averageSpeedOfSuccess;

    private Integer averageSpeedOfAll;

    private Integer meanSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;
}
