package coordinate.domain;

import java.util.Objects;

public class Point {
    private static final double POW_NUM = 2.0;

    private final PointElement x;
    private final PointElement y;

    private Point(final Integer x, final Integer y) {
        this.x = PointElement.of(x);
        this.y = PointElement.of(y);
    }

    public static Point of(final Integer x, final Integer y) {
        return new Point(x, y);
    }

    double getDistance(final Point other) {
        int lengthOfX = this.minusX(other);
        int lengthOfY = this.minusY(other);
        return Math.sqrt(Math.pow(lengthOfX, POW_NUM) + Math.pow(lengthOfY, POW_NUM));
    }

    private int minusX(Point other) {
        return this.x.minus(other.x);
    }

    private int minusY(Point other) {
        return this.y.minus(other.y);
    }

    boolean isSameX(final Point other) {
        return this.x.equals(other.x);
    }

    boolean isSameY(final Point other) {
        return this.y.equals(other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point other = (Point) o;
        return (this.x.equals(other.x) && this.y.equals(other.y));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point" + "(" + x + "," + y + ")";
    }
}
