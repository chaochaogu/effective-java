package com.chaochaogu.primitive;

import java.util.Comparator;

/**
 * @author chaochao Gu
 * @date 2019/9/16
 */
public class Main {

    public static void main(String[] args) {

        Integer a1 = 333;
        Integer a2 = 333;
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        System.out.println(naturalOrder.compare(new Integer(42), new Integer(42)));

        Comparator<Integer> naturalOrder1 = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; // Auto-unboxing
            return i < j ? -1 : (i == j ? 0 : 1);
        };
    }
}
