package com.jasmine.crawler.url.store.pojo.req;

import com.jasmine.crawl.common.pojo.entity.Url;
import lombok.Data;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class SaveUrlResultReq {
    private Integer downSystemSiteId;

    private List<Url> newUrls;

    private List<String> succeedUrls;

    private List<String> badUrls;

    private List<String> failedUrls;

    private List<String> urlNotToRun;
}
