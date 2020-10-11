package com.jasmine.crawler.web.admin.pojo.vo;

import com.jasmine.crawler.common.pojo.entity.CrawlTask;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrawlTaskDetail extends CrawlTask {
    private  String downSystemSiteName;
}
