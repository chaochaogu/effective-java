package com.chaochaogu.inheritfurther;

import java.time.Instant;

/**
 * @author chaochao gu
 * @date 2019/8/20
 */
public class Sub extends Super {

    // Blank final - set by constructor
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    // overriding method invoked by superclass constructor
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
