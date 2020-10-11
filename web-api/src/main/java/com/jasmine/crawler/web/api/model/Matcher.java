package com.jasmine.crawler.web.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter
@Setter
@Builder
public class Matcher {
    private Pattern pattern;

    private Integer downSystemSiteId;
}