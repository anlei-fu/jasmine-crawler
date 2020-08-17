package com.jasmine.crawler.web.api.pojo.req;

import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SaveUrlResultReq {

    private Integer downSystemSiteId;

    private List<Url> newUrls;

    private List<Integer> badUrls;

    private List<Integer> succeedUrls;

    private List<Integer> failedUrls;

    private List<Integer> unCrawledUrls;

    private Integer taskId;
}
