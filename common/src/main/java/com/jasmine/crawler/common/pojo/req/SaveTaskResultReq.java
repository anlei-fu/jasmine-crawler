package com.jasmine.crawler.common.pojo.req;

import com.jasmine.crawler.common.pojo.dto.PageResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveTaskResultReq {

    /**
     * Task of result
     */
    private Integer taskId;

    /**
     * Result of task @see {@enum TaskResult}
     */
    private Integer taskResult;

    /**
     * The result Msg of task
     */
    private String msg;

    /**
     * Total url to crawl
     */
    private Integer urlTotal;

    /**
     * Page results
     */
    private List<PageResult> pageResults;

    /**
     * Statistics field
     */
    private Integer averageSpeedOfSuccess;

    /**
     * Statistics field
     */
    private Integer averageSpeedOfAll;

    /**
     * Statistics field
     */
    private Integer medianSpeedOfSuccess;

    /**
     * Statistics field
     */
    private Integer maxSpeedOfSuccess;
}
