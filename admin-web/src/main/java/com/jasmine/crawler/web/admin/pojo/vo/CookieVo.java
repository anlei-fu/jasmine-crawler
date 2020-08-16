package com.jasmine.crawler.web.admin.pojo.vo;

import com.jasmine.crawler.common.pojo.entity.Cookie;
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
public class CookieVo extends Cookie {
    private  Integer siteId;

    private  Integer maxUseCount;

    private  Integer maxBlockCount;

}
