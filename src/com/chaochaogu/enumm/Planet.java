package com.chaochaogu.enumm;

/**
 * Enum type with data and behavior
 *
 * @author chaochao Gu
 * @date 2019/8/29
 */
public enum Planet {

    /**
     * 水星
     */
    MERCURY(3.302e+23, 2.439e6),
    /**
     * 金星
     */
    VENUS(4.869e+24, 6.052e6),
    /**
     * 地球
     */
    EARTH(5.975e+24, 6.378e6),
    /**
     * 火星
     */
    MARS(6.419e+23, 3.393e6),
    /**
     * 木星
     */
    JUPITER(1.899e+27, 7.149e7),
    /**
     * 土星
     */
    SATURN(5.685e+26, 6.027e7),
    /**
     * 天王星
     */
    URANUS(8.683e+25, 2.556e7),
    /**
     * 海王星
     */
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass; // In kilograms

    private final double radius; // In meters

    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}
