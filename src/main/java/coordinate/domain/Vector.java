package coordinate.domain;

import coordinate.domain.point.Point;
import coordinate.util.DoubleCompare;

import java.util.Objects;

public class Vector {
    private static final int ORTHOGONAL = 0;
    private static final int SQUARE = 2;

    private final int x;
    private final int y;

    public Vector(Point startPoint, Point endPoint) {
        this.x = endPoint.calculateXDistance(startPoint);
        this.y = endPoint.calculateYDistance(startPoint);
    }

    public boolean isNormalVector(Vector vector) {
        return calculateInnerProduct(vector) == ORTHOGONAL;
    }

    public int calculateInnerProduct(Vector vector) {
        return this.x * vector.x + this.y * vector.y;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, SQUARE) + Math.pow(y, SQUARE));
    }

    public boolean isParallelVector(Vector vector) {
        return DoubleCompare.deltaCompare(Math.abs(this.calculateInnerProduct(vector)), this.length() * vector.length(), 0.001);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return x == vector.x &&
                y == vector.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
