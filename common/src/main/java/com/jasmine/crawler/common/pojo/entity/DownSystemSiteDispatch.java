package com.jasmine.crawler.common.pojo.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownSystemSiteDispatch extends EnableStatusFeature {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Source down system site id
     */
    private Integer sourceDownSystemSiteId;

    /**
     * Target down system site id
     */
    private Integer targetDownSystemSiteId;

    /**
     * Regex pattern to match
     */
    private String matchPattern;

    private Integer order;

}
