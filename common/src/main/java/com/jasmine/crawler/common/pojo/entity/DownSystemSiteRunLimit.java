package com.jasmine.crawler.common.pojo.entity;

import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DownSystemSiteRunLimit extends EnableStatusFeature {

    /**
     * Target down system site
     */
    private Integer downSystemSiteId;

    /**
     * Week day type
     */
    private Integer weekDayType;

    /**
     * Hour
     */
    private Integer hour;
}
