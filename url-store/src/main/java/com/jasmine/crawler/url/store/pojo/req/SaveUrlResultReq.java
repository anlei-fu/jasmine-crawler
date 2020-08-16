package com.jasmine.crawler.url.store.pojo.req;

import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveUrlResultReq {
    private Integer downSystemSiteId;

    private List<Url> newUrls;

    private List<Integer> succeedUrls;

    private List<Integer> badUrls;

    private List<Integer> failedUrls;

    private List<Integer> unStartedUrl;
}
