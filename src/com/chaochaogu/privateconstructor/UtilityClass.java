package com.chaochaogu.privateconstructor;

/**
 * Noninstantiable utility class
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class UtilityClass {

    private UtilityClass(){
        // suppress default constructor for noninstantiability
        throw new AssertionError();
    }
    // Remained omitted
}
