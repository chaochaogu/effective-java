package com.chaochaogu.variableparameter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chaochao Gu
 * @date 2019/8/27
 */
public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qqwe");
        dangerous(list);

        String[] attributes = pickTwo("Good", "Fast", "Cheap");
    }

    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = new ArrayList<>();
        intList.add(42);
        Object[] objects = stringLists;
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
    }

    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(b, c);
            case 2:
                return toArray(a, c);
        }
        throw new AssertionError(); // Can't get here
    }

    // Safe method with a generic varargs parameter
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    // List as a typesafe alternative to a generic varargs parameter
    static <T> List<T> flatten1(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        throw new AssertionError();
    }

    // Simple use of varargs
    static int sun(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // The wrong way to use varargs to pass one or more arguments!
    static int min(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Too few arguments");
        }
        int min = args[0];
        for (int arg : args) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    // The right way to use varargs
    static int min1(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int remainArg : remainingArgs) {
            if (remainArg < min) {
                min = remainArg;
            }
        }
        return min;
    }
}

