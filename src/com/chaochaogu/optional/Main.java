package com.chaochaogu.optional;

import java.util.*;

/**
 * @author chaochao gu
 * @date 2019/9/15
 */
public class Main {

    public static void main(String[] args) {

        List<String> words = new ArrayList();

        // Using an optional to provide a chosen default value
        String lastWordInLexicon = max1(words).orElse("No words");

        String s = max1(words).isPresent() ? max1(words).get() : "No words";
    }

    /**
     * Returns maximum value in collection - throws exception if empty
     *
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty Collection");
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(result);
            }
        }
        return result;
    }

    /**
     * Returns Maximum value in collection as an Optional<E>
     *
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> Optional<E> max1(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return Optional.of(result);
    }

    /**
     * Returns max val in collection as Optional<E> - uses stream
     *
     * @param c
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
}
