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

    public static Vector getVector(Points points, int startPoint, int endPoint) {
        return new Vector(points.get(startPoint), points.get(endPoint));
    }

    public Vector sum(Vector vector) {
        return new Vector(new Delta(this.deltaX.sum(vector.deltaX)), new Delta(this.deltaY.sum(vector.deltaY)));
    }

    public int dotProduct(Vector vector) {
        return vector.deltaX.multiply(this.deltaX) + vector.deltaY.multiply(this.deltaY);
    }

    public int absCrossProduct(Vector vector) {
        return Math.abs(this.deltaX.multiply(vector.deltaY) - this.deltaY.multiply(vector.deltaX));
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
