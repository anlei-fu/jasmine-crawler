package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteAccountRunLimit extends EnableStatusFeature {

    private Integer siteAccountType;

    private Integer monthDayType;
}
