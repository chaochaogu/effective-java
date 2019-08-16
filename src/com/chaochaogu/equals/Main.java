package com.chaochaogu.equals;

import java.util.Objects;

/**
 * @author chaochao Gu
 * @date 2019/8/16
 */
public class Main {

    public static void main(String[] args) {

        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));

        Float.compare(1.0f, 2.0f);
        Double.compare(1.0, 2.0);
        Objects.equals("s", 3);

    }
}
