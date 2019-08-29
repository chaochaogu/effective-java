package com.chaochaogu.enummap;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class Plant {

    public enum LifeCycle {
        /**
         * 一年生植物
         */
        ANNUAL,
        /**
         * 多年生植物
         */
        PERENNIAL,
        /**
         * 两年生植物
         */
        BIENNIAL
    }

    final String name;

    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
