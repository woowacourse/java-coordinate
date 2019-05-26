package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int SQUARE = 2;

    private final Coordinate x;
    private final Coordinate y;

    public Point(int x, int y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(Math.pow(x.getDistance(point.x), SQUARE) + Math.pow(y.getDistance(point.y), SQUARE));
    }

    public int getXCoordinate() {
        return x.getCoordinate();
    }

    public int getYCoordinate() {
        return y.getCoordinate();
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

    @Override
    public int compareTo(Point p) {
        if ((x.compare(p.x)) || (x.equals(p.x) && y.compare(p.y))) {
            return -1;
        }
        return 1;
    }
}
