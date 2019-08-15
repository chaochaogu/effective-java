package com.chaochaogu.singleton;

/**
 * singleton with static factory
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class Alex {

    private static final Alex INSTANCE = new Alex();

    private Alex(){}

    public static Alex getInstance(){
        return INSTANCE;
    }

    public void leaveTheBuilding(){}

    // readResolve method to preserve singleton property
    private Object readResolve(){
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
