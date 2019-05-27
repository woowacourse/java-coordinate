package com.woowa.coordinate.domain;

public class Vector {
    private final Coordinate deltaX;
    private final Coordinate deltaY;

    public Vector(Point start, Point end) {
        this.deltaX = new Coordinate(start.subtractX(end));
        this.deltaY = new Coordinate(start.subtractY(end));
    }

    public int dotProduct(Vector that) {
        return this.deltaX.multiply(that.deltaX) + this.deltaY.multiply(that.deltaY);
    }
}
