package com.chaochaogu.unnecessaryobject;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class Main {

    public static void main(String[] args) {

        String s = new String("bikini"); // DON'T DO THIS!
        String s1 = "bikini";
        LocalTime start = LocalTime.now();
        sum();
        LocalTime end = LocalTime.now();
        System.out.println(ChronoUnit.SECONDS.between(start, end));
    }

    private static long sum(){
        // Long should be replaced to long here!
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE ; i++) {
            sum += i;
        }
        return sum;
    }

    // performance can be greatly improved
    static boolean isRomanNumber(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}
