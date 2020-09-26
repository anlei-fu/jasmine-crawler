package com.jasmine.crawler.common.util;

import com.jasmine.crawler.common.component.impl.WeightWrapper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <E> List<List<E>> split(Collection<E> collection, int count) {
        List<List<E>> result = new LinkedList<>();
        int k = 0;
        List<E> ls = new LinkedList<>();
        for (final E e : collection) {
            ls.add(e);
            if (++k % count == 0) {
                result.add(ls);
                ls = new LinkedList<>();
            }
        }

        if (ls.size() != 0)
            result.add(ls);

        return result;
    }

    public static <E> List<E> selectTop(Collection<E> collection, Function<E, Float> valueGetter, int count, boolean asc) {
        Comparator<E> compare = asc ? (x, y) -> (int) (valueGetter.apply(x) - valueGetter.apply(y))
                : (x, y) -> (int) (valueGetter.apply(y) - valueGetter.apply(x));

        return collection.stream()
                .sorted(compare)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static <TKey, TValue, E> Map<TKey, List<TValue>> group(Collection<E> collection, Function<E, TKey> keySelector, Function<E, TValue> valueSelector) {
        Map<TKey, List<TValue>> map = new HashMap<>();

        collection.stream().forEach(element -> {
            TKey key = keySelector.apply(element);
            TValue value = valueSelector.apply(element);
            map.putIfAbsent(key, new ArrayList<>());
            List<TValue> list = map.get(key);
            list.add(value);
        });

        return map;
    }

    public static <TKey, TValue, E> List<WeightWrapper<TKey>> groupCount(
            Collection<E> collection,
            Function<E, TKey> keySelector,
            Function<E, TValue> valueSelector,
            Function<TValue, Float> weightSelector,
            boolean asc) {
        Map<TKey, List<TValue>> map = group(collection, keySelector, valueSelector);
        return groupCount(map, weightSelector, asc);
    }

    public static <TKey, TValue, E> List<WeightWrapper<TKey>> groupCount(Map<TKey, List<TValue>> map, Function<TValue, Float> weightSelector, boolean asc) {
        List<WeightWrapper<TKey>> result = new ArrayList<>();
        map.forEach((x, y) -> {
            Float sum = 0f;
            for (TValue e : y) {
                sum += weightSelector.apply(e);
            }
            result.add((WeightWrapper<TKey>) WeightWrapper.builder().key(x).weight(sum).build());
        });
        Comparator<WeightWrapper<TKey>> compare = asc ? (x, y) -> (int) (x.getWeight() - y.getWeight())
                : (x, y) -> (int) (y.getWeight() - x.getWeight());
        result.sort(compare);

        return result;
    }
}
