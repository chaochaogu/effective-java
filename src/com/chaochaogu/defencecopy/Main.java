package com.chaochaogu.defencecopy;

import java.util.Date;

/**
 * @author chaochao Gu
 * @date 2019/9/12
 */
public class Main {

    public static void main(String[] args) {

        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies the internals of p !
        end.setYear(78);

        // Second attack on the internals of a period instance
        // Modifies the internals of p !
        p.end().setYear(78);
    }
}
