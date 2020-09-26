package com.jasmine.crawler.web.admin.pojo.req;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateDownSystemRunLimitReq {

    private  Integer downSystemSiteId;

    private List<Integer> enables;

    private  List<Integer> disables;
}
