package com.chaochaogu.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author chaochao Gu
 * @date 2019/9/5
 */
public class Main {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        System.out.println(PowerSet.of(set));
    }

    // Adapter from Stream<E> to Iterable<E>
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Adapter from Iterable<E> to Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
