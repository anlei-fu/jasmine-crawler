package com.jasmine.crawl.web.api.pojo.req;

import com.jasmine.crawl.web.api.pojo.entity.Url;
import lombok.Data;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class TaskResultReq {
    private List<String> data;

    private List<Url> newUrls;

    private List<String> badUrls;

    private List<String> succeedUrls;

    private List<String> failedUrls;

    private  List<String> unStartUrls;

    private Integer taskStatus;

    private Integer taskId;

    private Integer averageSpeedOfSuccess;

    private Integer averageSpeedOfAll;

    private Integer meanSpeedOfSuccess;

    private Integer maxSpeedOfSuccess;
}
