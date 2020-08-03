package com.jasmine.crawler.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    /**
     * Down site id of url
     */
    private Integer downSystemSiteId;

    /**
     * Url status see {@enum UrlStatus}
     */
    private Integer urlStatus;

    /**
     * The depth of the url
     */
    private Integer depth;

    /**
     * Url
     */
    private String url;

    /**
     * Refer url
     */
    private String referUrl;

    /**
     * Url type
     */
    private Integer urlType;
}
