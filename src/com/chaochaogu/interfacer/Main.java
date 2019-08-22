package com.chaochaogu.interfaced;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * @author chaochao Gu
 * @date 2019/8/22
 */
public class Main {

    public static void main(String[] args) {

    }

    // Concrete implementation built atop skeletal implementation
    static List<Integer> intArrayList(int[] a) {
        Objects.requireNonNull(a);

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return a[i]; // Autoboxing
            }

            @Override
            public Integer set(int i, Integer value) {
                int oldvalue = a[i];
                a[i] = value; // Auto unboxing
                return oldvalue; // Autoboxing
            }

            @Override
            public int size() {
                return a.length;
            }
        };
    }
}
