package com.jasmine.crawler.web.admin.pojo.vo;

import com.jasmine.crawler.common.pojo.entity.SiteAccount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteAccountVo extends SiteAccount {

    private Integer maxUseCount;

    private Integer maxBlockCount;
}
