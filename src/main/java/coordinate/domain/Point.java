package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int MIN_SCALAR_VALUE = 0;
    private static final int MAX_SCALAR_VALUE = 25;
    private final Scalar x;
    private final Scalar y;

    public Point(final Scalar x, final Scalar y) {
        if (x.isLessThan(MIN_SCALAR_VALUE) || x.isMoreThan(MAX_SCALAR_VALUE)) {
            throw new IllegalArgumentException(String.format("X값은 %d ~ %d 입니다", MIN_SCALAR_VALUE, MAX_SCALAR_VALUE));
        }
        if (y.isLessThan(MIN_SCALAR_VALUE) || y.isMoreThan(MAX_SCALAR_VALUE)) {
            throw new IllegalArgumentException(String.format("Y값은 %d ~ %d 입니다", MIN_SCALAR_VALUE, MAX_SCALAR_VALUE));
        }
        this.x = x;
        this.y = y;
    }

    public double sub(Point point) {
        return Math.sqrt(Math.pow(x.sub(point.x), 2) + Math.pow(y.sub(point.y), 2));
    }

    public Point calVector(Point point) {
        return new Point(Scalar.of(point.x.getNo() - x.getNo()), Scalar.of(point.y.getNo() - y.getNo()));
    }

    public Scalar calDotProduct(Point vector) {
        return Scalar.of(x.multiply(vector.getX()) + y.multiply(vector.getY()));
    }

    private Point sumOfVector(Point vector) {
        return new Point(Scalar.of(x.add(vector.x)), Scalar.of(y.add(vector.y)));
    }

    public Point calCrossPoint(Point firstVector, Point secondVector) {
        Point addedVector = firstVector.sumOfVector(secondVector);
        return new Point(Scalar.of(x.add(addedVector.x)), Scalar.of(y.add(addedVector.y)));
    }

    Scalar getX() {
        return x;
    }

    Scalar getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(getX(), point.getX()) &&
                Objects.equals(getY(), point.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public int compareTo(Point o) {
        if (y == o.y) {
            return x.sub(o.x);
        }
        return y.sub(o.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
