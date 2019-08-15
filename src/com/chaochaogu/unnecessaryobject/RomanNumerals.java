package com.chaochaogu.unnecessaryobject;

import java.util.regex.Pattern;

/**
 * reusing expensive object for improved performance
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class RomanNumerals {

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeral(String s){
        return ROMAN.matcher(s).matches();
    }
}
