package com.jasmine.crawler.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownSystemSiteRunLimit extends  EnableStatusFeature {

    private  Integer downSystemSiteId;

    private  Integer weekDayType;

    private  Integer dayPartType;

}
