package com.chaochaogu.staticfactory;

/**
 * @author chaochao Gu
 * @date 2019/8/9
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}
