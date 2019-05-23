package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point>{
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double sub(Point secondPoint) {
        return Math.sqrt(Math.pow(x - secondPoint.x, 2) + Math.pow(y - secondPoint.y, 2));
    }


    public Point calVector(Point point) {
        return new Point(point.x - x, point.y - y);
    }

    public int calDotProduct(Point vector) {
        return (vector.x * x) + (vector.y * y);
    }

    public Point sumOfVector(Point vector) {
        return new Point(this.x + vector.x, this.y + vector.y);
    }

    public Point calCrossPoint(Point firstVector, Point secondVector) {
        Point addedVector = firstVector.sumOfVector(secondVector);
        return new Point(x + addedVector.x, y + addedVector.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point o) {
        if (this.y == o.y) {
            return this.x - o.x;
        }
        return this.y - o.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
