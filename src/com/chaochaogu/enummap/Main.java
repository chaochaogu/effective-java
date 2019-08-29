package com.chaochaogu.enummap;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class Main {

    public static void main(String[] args) {

        Plant[] garden = null;

        // Using ordinal() to index into an array - DON'T DO THIS !
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < Plant.LifeCycle.values().length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // Using an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle1 = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantByLifeCycle1.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantByLifeCycle1.get(p.lifeCycle).add(p);
        }

        // Naive stream-based approach - unlikely to produce an EnumMap
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle)));

        // Using a stream and an EnumMap to associate data with an enum
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }
}
