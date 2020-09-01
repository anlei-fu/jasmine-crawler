package com.jasmine.crawler.common.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

        if(ls.size()!=0)
        result.add(ls);

        return result;
    }
}
