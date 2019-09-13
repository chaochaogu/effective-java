package com.chaochaogu.overload;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chaochao gu
 * @date 2019/9/13
 */
public class SetList {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
            /// list.remove((Integer) i);
        }

        System.out.println(set + " " + list);
    }
}
