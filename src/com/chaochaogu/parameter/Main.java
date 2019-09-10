package com.chaochaogu.parameter;

/**
 * Private helper function for a recursive sort
 *
 * @author chaochao Gu
 * @date 2019/9/10
 */
public class Main {

    public static void main(String[] args) {

    }

    private static void sort(long[] a, int offset, int length) {

        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }
}
