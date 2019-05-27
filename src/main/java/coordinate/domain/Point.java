package coordinate.domain;

import java.util.Objects;

public class Point {
    private static final int SQUARE = 2;
    private Coordinate x;
    private Coordinate y;

    public Point(int x, int y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    double calculateLength(Point point) {
        return Math.sqrt(Math.pow(x.subCoordinate(point.x),SQUARE) +  Math.pow(y.subCoordinate(point.y),SQUARE));
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
