package com.chaochaogu.annotation;

/**
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Sample2 {

    /**
     * Test should pass
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int a = 10 / 0;
    }

    /**
     * Test should fail - not ArithmeticException
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int[] intArrsy = new int[0];
        int a = intArrsy[1];
    }

    /**
     * Test should fail - no Exception
     */
    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
    }
}
