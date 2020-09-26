package com.jasmine.crawler.common.component.impl;

import com.jasmine.crawler.common.component.RandomPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JasmineRandomPicker<T> implements RandomPicker<T> {
    @Override
    public List<T> pick(List<T> candidates, int count) {

        if (count < 0)
            return new ArrayList<>();

        if (candidates.size() <= count)
            return candidates;

        List<T> result = new ArrayList<>();
        int t = 0;
        while (t < count) {
            Random rd = new Random(System.currentTimeMillis());
            int index = rd.nextInt(candidates.size());
            result.add(candidates.get(index));
            candidates.remove(index);
            t++;
        }

        return result;
    }
}
