package com.chaochaogu.inherit;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chaochao gu
 * @date 2019/8/20
 */
public class Main {

    public static void main(String[] args) {

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());

        Set<Instant> times = new InstrumentedSet<>(new TreeSet<>());
        Set ss = new InstrumentedSet<>(new HashSet<>(16));
    }
}
