package com.jasmine.crawler.common.pojo.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Getter
@Setter
public class PageTimeReq extends PageReq {
    private String createTimeStart;

    private String createTimeEnd;
}
