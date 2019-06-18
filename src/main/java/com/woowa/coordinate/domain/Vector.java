package com.woowa.coordinate.domain;

import java.util.Objects;

public class Vector implements Comparable {
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
        Vector vector = new Vector(points.get(i1), points.get(i2));
        return vector;
    }

    public Vector sum(Vector vector) {
        return new Vector(new Delta(this.deltaX.sum(vector.deltaX)), new Delta(this.deltaY.sum(vector.deltaY)));
    }

    public int dotProduct(Vector vector) {
        return vector.deltaX.multiply(this.deltaX) + vector.deltaY.multiply(this.deltaY);
    }

    public int crossProduct(Vector vector) {
        return this.deltaX.multiply(vector.deltaY) - this.deltaY.multiply(vector.deltaX);
    }

    public double length() {
        return Math.sqrt(deltaX.square() + deltaY.square());
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.length() - ((Vector) o).length(), 0);
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
