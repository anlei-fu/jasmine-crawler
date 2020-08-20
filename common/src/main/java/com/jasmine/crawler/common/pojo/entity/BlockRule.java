package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
@Data
public class BlockRule {

    private  Integer id;

    private Integer downSystemSiteId;

    private Integer compareType;

    private Integer httpStatus;

    private Integer pageResult;

    private String keywords;

    private Date createTime;
}
