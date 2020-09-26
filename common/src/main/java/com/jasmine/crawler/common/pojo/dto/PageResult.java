package com.jasmine.crawler.common.pojo.dto;

import com.jasmine.crawler.common.pojo.entity.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    /**
     * Url id of page result
     */
    private Integer id;

    /**
     * The task id
     */
    private Integer taskId;

    /**
     * Target down system site of task
     */
    private Integer downSystemSiteId;

    /**
     * The data of page , json object in string format
     */
    private String data;

    /**
     * The page extracting msg ,using for analyzing extracting script
     */
    private String msg;

    /**
     * The http status of downloading page
     */
    private Integer httpStatus;

    /**
     * The page crawl result
     */
    private Integer pageResult;

    /**
     * Crawl time
     */
    private Date crawlTime;

    /**
     * The detected new urls of target page
     */
    private List<Url> newUrls;
}
