package com.chaochaogu.hierarchy;


/**
 * Tagged class - vastly inferior to a class hierarchy !
 * @author chaochao Gu
 * @date 2019/8/22
 */
public class Figure {

    enum Shape {RECTANGLE, CIRCLE}

    /**
     * Tag field - the shape of this figure
     */
    final Shape shape;

    /**
     * These tags are used only if the shape is rectangle
     */
    double length;
    double width;

    /**
     * This field is used only if the shape is circle
     */
    double radius;

    /**
     * Constructor for circle
     * @param radius
     */
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    /**
     * Constructor for rectangle
     * @param length
     * @param width
     */
    Figure(double length, double width) {
        shape = Shape.CIRCLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI * (radius * radius);
            case RECTANGLE:
                return length * width;
            default:
                throw new AssertionError(shape);
        }
    }
}
