package com.jasmine.crawler.common.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Dictionary {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * Dictionary type
     */
    private String type;

    /**
     * Dictionary value
     */
    private String value;

    /**
     * Label of value
     */
    private String label;

    /**
     * Use to sort
     */
    private  Integer sortNumber;

    /**
     * Color of value
     */
    private String color;

    /**
     * Create time
     */
    private Date createTime;
}
