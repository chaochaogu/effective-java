package com.chaochaogu.annotation;

/**
 * Program containing marker annotations
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Sample {

    /**
     * Test should pass
     */
    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    /**
     * Test should fail
     */
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    /**
     * Invalid use : nonstatic method
     */
    @Test
    public void m5() {
    }

    public static void m6() {
    }

    /**
     * Test should fail
     */
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }
}
