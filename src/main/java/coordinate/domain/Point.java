package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final Coordinate x;
    private final Coordinate y;

    public Point(final int x, final int y) {
        this.x = Coordinate.valueOf(x);
        this.y = Coordinate.valueOf(y);
    }

    public double getDistance(final Point point) {
        return Math.sqrt(Math.pow((x.getMinus(point.x)), 2) + Math.pow((y.getMinus(point.y)), 2));
    }

    public int distanceSquare(final Point point) {
        int absX = x.getMinus(point.x);
        int absY = y.getMinus(point.y);
        return absX * absX + absY * absY;
    }

    public int getX() {
        return x.getCoordinate();
    }

    public int getY() {
        return y.getCoordinate();
    }

    @Override
    public int compareTo(Point o) {
        if (y.compareTo(o.y) == 1) {
            return 1;
        }
        if (x.compareTo(o.x) == 1) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
