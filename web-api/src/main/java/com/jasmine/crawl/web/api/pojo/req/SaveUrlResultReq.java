package com.jasmine.crawl.web.api.pojo.req;

import com.jasmine.crawl.common.pojo.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SaveUrlResultReq {
    private List<Url> newUrls;

    private List<String> badUrls;

    private List<String> succeedUrls;

    private List<String> failedUrls;

    private List<String> unStartUrls;

    private Integer downSystemSiteId;
}
