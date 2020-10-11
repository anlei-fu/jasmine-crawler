package com.jasmine.crawler.web.admin.pojo.vo;

import com.jasmine.crawler.common.pojo.entity.DownSystemSiteDispatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownSystemSiteDispatchDetail extends DownSystemSiteDispatch {

    private  String siteName;

    private  String targetDownSystemSiteName;
}
