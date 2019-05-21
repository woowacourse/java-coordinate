package coordinate.domain;

import java.util.Objects;

public class Point {
    private final X x;
    private final Y y;

    public Point(final int x, final int y) {
        this.x = new X(x);
        this.y = new Y(y);
    }

    public double length(final Point other) {
        double squareOfX = square(this.x.getX(), other.x.getX());
        double squareOfY = square(this.y.getY(), other.y.getY());
        return Math.sqrt(squareOfX + squareOfY);
    }

    private double square(final int first, final int second) {
        return Math.pow(first - second, 2);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
