package com.jasmine.crawler.common.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Use to record dispatch info
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DispatchRecord {

    /**
     * Unique id
     */
    private Integer id;

    /**
     * The task the record belong to
     */
    private Integer taskId;

    /**
     * Dispatch status see {@enum DispatchStatus}
     */
    private Integer dispatchStatus;

    /**
     * The dispatch msg
     */
    private String dispatchMsg;

    private Date createTime;
}
