package com.jasmine.crawler.url.store.service;

import com.jasmine.crawl.common.pojo.entity.Url;
import com.jasmine.crawler.url.store.pojo.req.GetUrlForTaskReq;
import com.jasmine.crawler.url.store.pojo.req.SaveUrlResultReq;

import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public interface UrlService {

    List<Url> getUrlForTask(GetUrlForTaskReq req);

    boolean saveUrlResult(SaveUrlResultReq req);
}
