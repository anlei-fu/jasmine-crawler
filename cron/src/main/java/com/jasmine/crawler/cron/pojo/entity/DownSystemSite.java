package com.jasmine.crawler.cron.pojo.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Builder
@Getter
@Setter
public class DownSystemSite extends  EnableStatusFeature{
    private  Integer id;
    private  Integer siteId;

    private  Integer downSystemId;
}
