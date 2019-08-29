package com.chaochaogu.enumm;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class Main {

    public static void main(String[] args) {
        for (Operation op : Operation.values()) {
            System.out.println(op.name() + " : " + op.ordinal());
        }
    }
}
