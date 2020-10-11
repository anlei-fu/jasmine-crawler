package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EnableTask extends CreateTimeFeature {
    private Integer id;

    private Date enableTime;

    private Date executeTime;

    private Integer downSystemSiteId;
}
