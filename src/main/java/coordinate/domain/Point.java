package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int SQUARE = 2;
    private static final int COORDINATE_MAX_SIZE = 24;
    private static final int COORDINATE_MIN_SIZE = 0;

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        checkCoordinateSize(x, y);
        this.x = x;
        this.y = y;
    }

    public double sub(Point secondPoint) {
        return Math.sqrt(Math.pow(x - secondPoint.x, SQUARE) + Math.pow(y - secondPoint.y, SQUARE));
    }

    public int calDotProduct(Point vector) {
        return (vector.x * x) + (vector.y * y);
    }

    public Point calVector(Point point) {
        return new Point(point.x - x, point.y - y);
    }

    public Point calCrossPoint(Point firstVector, Point secondVector) {
        Point addedVector = firstVector.calSumOfVector(secondVector);
        return new Point(x + addedVector.x, y + addedVector.y);
    }

    public Point calSumOfVector(Point vector) {
        return new Point(this.x + vector.x, this.y + vector.y);
    }

    private static void checkCoordinateSize(int x, int y) {
        if ((x < COORDINATE_MIN_SIZE || x > COORDINATE_MAX_SIZE) ||
                (y < COORDINATE_MIN_SIZE || y > COORDINATE_MAX_SIZE)) {
            throw new IllegalArgumentException("좌표는 0부터 24까지만 입력할 수 있습니다");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}
