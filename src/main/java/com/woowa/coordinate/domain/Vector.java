package com.woowa.coordinate.domain;

import java.util.Objects;

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

    public int dotProduct(Vector vector) {
        return this.deltaX.multiply(vector.deltaX) + this.deltaY.multiply(vector.deltaY);
    }

    public int crossProduct(Vector vector) {
        return this.deltaX.multiply(vector.deltaX) - this.deltaY.multiply(vector.deltaY);
    }

    public double length() {
        return Math.sqrt(deltaX.square() + deltaY.square());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(deltaX, vector.deltaX) &&
                Objects.equals(deltaY, vector.deltaY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deltaX, deltaY);
    }
}
