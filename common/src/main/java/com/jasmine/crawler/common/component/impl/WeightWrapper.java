package com.jasmine.crawler.common.component.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WeightWrapper<TKey> {
    private TKey key;

    private Float weight;
}
