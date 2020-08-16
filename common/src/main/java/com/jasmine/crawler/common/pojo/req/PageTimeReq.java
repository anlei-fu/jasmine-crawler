package com.jasmine.crawler.common.pojo.req;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageTimeReq extends PageReq {
    private String createTimeStart;

    private String createTimeEnd;
}
