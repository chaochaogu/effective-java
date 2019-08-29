package com.chaochaogu.enumm;

/**
 * @author chaochao Gu
 * @date 2019/8/29
 */
public class WeightTable {

    public static void main(String[] args) {

        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
        }
    }
}
