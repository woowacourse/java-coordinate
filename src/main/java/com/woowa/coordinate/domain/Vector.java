package com.woowa.coordinate.domain;

public class Vector {
    private final Delta deltaX;
    private final Delta deltaY;

    public Vector(Point start, Point end) {
        this.deltaX = new Delta(start.subtractX(end));
        this.deltaY = new Delta(start.subtractY(end));
    }

    public Vector(Delta deltaX, Delta deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static Vector get(Points points, int i1, int i2) {
        return new Vector(points.get(i1), points.get(i2));
    }

    public Vector sum(Vector vector) {
        return new Vector(this.deltaX.sum(vector.deltaX), this.deltaY.sum(vector.deltaY));
    }

    public int dotProduct(Vector o) {
        return this.deltaX.multiply(o.deltaX) + this.deltaY.multiply(o.deltaY);
    }

    public int crossProduct(Vector o) {
        return this.deltaX.multiply(o.deltaX) - this.deltaY.multiply(o.deltaY);
    }
}
