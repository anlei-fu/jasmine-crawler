package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

@Data
public class BlockRule extends EnableStatusFeature {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * Target down system site
     */
    private Integer downSystemSiteId;

    /**
     * The check type of rule see {@enum CheckType}
     */
    private Integer checkType;

    /**
     * Expected downloading http status
     */
    private Integer httpStatus;

    /**
     * Expected page result
     */
    private Integer pageResult;

    /**
     * key words to match, json array in string format
     */
    private String keywords;
}
