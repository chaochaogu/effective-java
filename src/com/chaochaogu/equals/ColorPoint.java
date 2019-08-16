package com.chaochaogu.equals;

import java.awt.*;
import java.util.Objects;

/**
 * Adds a value component without violating the equals contract
 * @author chaochao Gu
 * @date 2019/8/16
 */
public class ColorPoint extends Point {

    private final Point point;

    private final Color color;

    public ColorPoint(int x, int y, Color color){
        super(x, y);
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ColorPoint)){
            return false;
        }
        ColorPoint cp = (ColorPoint) obj;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
