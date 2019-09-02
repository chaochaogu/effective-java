package com.chaochaogu.annotation;

import java.util.ArrayList;

/**
 * Code containing a repeated annotation
 * @author chaochao Gu
 * @date 2019/9/2
 */
public class Sample4 {

    @ExceptionTest2(ArrayIndexOutOfBoundsException.class)
    @ExceptionTest2(NullPointerException.class)
    public static void doublyBad(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(6, null);
    }
}
