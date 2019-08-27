package com.chaochaogu.variableparameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaochao Gu
 * @date 2019/8/27
 */
public class Main {

    public static void main(String[] args) {

    }

    static void dangerous(List<String>... stringLists){
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(42);

    }
}
