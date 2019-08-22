package com.chaochaogu.hierarchy;

/**
 * Class hierarchy replacement for a tagged class
 *
 * @author chaochao Gu
 * @date 2019/8/22
 */
public class Rectangle extends Figure {

    final double length;

    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
