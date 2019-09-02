package com.chaochaogu.annotation;

import java.util.ArrayList;

/**
 * Code containing an annotation with an array parameter
 *
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Sample3 {

    @ExceptionTest1({ArrayIndexOutOfBoundsException.class,
            NullPointerException.class})
    public static void doublyBad() {
        ArrayList<String> list = new ArrayList<>();
        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
