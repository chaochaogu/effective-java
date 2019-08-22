package com.chaochaogu.hierarchy;

/**
 * Class hierarchy replacement for a tagged class
 *
 * @author chaochao Gu
 * @date 2019/8/22
 */
public class Circle extends Figure {

    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
