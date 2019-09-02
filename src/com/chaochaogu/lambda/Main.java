package com.chaochaogu.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparingInt;

/**
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("12");
        list.add("123");
        list.add("1");

        // Anonymous class instance as a function object - obsolete !
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(list, comparingInt(String::length));

        list.sort(comparingInt(String::length));
    }
}
