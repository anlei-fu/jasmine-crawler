package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskSnapShot10Minute {

    private Integer downSystemSiteId;

    private Integer crawlerId;

    private Integer cookieId;

    private Integer successCount;

    private Integer failedCount;

    private Integer blockedCount;

    private Integer newUrlCount;

    private Integer successUrlCount;

    private Integer failedUrlCount;

    private Integer urlSyncCount;

    private Integer dataSyncCount;

    private Integer averageSpeedOfAll;

    private Integer averageSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;

    private Integer medianSpeedOfSuccess;

    private Date createTime;
}
