package com.chaochaogu.inheritfurther;

/**
 * @author chaochao gu
 * @date 2019/8/20
 */
public class Super {

    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
