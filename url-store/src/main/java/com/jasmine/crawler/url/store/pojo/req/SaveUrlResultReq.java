package com.jasmine.crawler.url.store.pojo.req;

import com.jasmine.crawler.url.store.pojo.entity.Url;
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

    private List<Url> succeedUrls;

    private List<Url> badUrls;
}
