package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BlockRule {

    private Integer id;

    private Integer downSystemSiteId;

    private Integer checkType;

    private Integer httpStatus;

    private Integer pageResult;

    private String keywords;

    private Date createTime;
}
