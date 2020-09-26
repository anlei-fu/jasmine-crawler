package com.jasmine.crawler.common.component;

import java.util.List;

public interface RandomPicker<T> {

    /**
     * Pick a data collection randomly
     *
     * @param candidates
     * @param count
     * @return
     */
    List<T> pick(List<T> candidates, int count);
}
