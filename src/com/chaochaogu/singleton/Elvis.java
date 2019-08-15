package com.chaochaogu.singleton;

/**
 * singleton with public final field
 * @author chaochao Gu
 * @date 2019/8/15
 */
public class Elvis {

    public static final Elvis INSTANCE = new Elvis();

    private Elvis(){}

    public void leaveTheBuilding(){}

    // readResolve method to preserve singleton property
    private Object readResolve(){
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
