package com.jasmine.crawler.common.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @Copyright (C) 四川千行你我科技有限公司
 * @Author: fuanlei
 * @Date:
 * @Description:
 */
public class CollectionUtils {
    public static <E> List<List<E>> split(Collection<E> collection, int count) {
        List<List<E>> result = new LinkedList<>();
        int k = 0;
        List<E> ls = new LinkedList<>();
        for (final E e : collection) {
            if (k % count == 0) {
                result.add(ls);
                ls = new LinkedList<>();
            }
            ls.add(e);
        }

        result.add(ls);
        return result;
    }
}
