package com.chaochaogu.collection;

import java.util.*;

/**
 * Returns the power set of an input set as custom collection
 *
 * @author chaochao Gu
 * @date 2019/9/9
 */
public class PowerSet {

    public static final <E> Collection<Set<E>> of(Set<E> s) {

        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("set too big" + s);
        }

        return new AbstractList<Set<E>>() {

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set) o);
            }
        };
    }
}
