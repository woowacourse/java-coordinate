package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final int MIN_COORDINATE_VALUE = 0;
    private static final int SQUARE = 2;

    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkCoordinateValue(x);
        checkCoordinateValue(y);
        this.x = x;
        this.y = y;
    }

    private void checkCoordinateValue(double coordinateValue) {
        if (coordinateValue <= MIN_COORDINATE_VALUE || coordinateValue > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표가 범위를 벗어났습니다.");
        }
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, SQUARE) + Math.pow(this.y - point.y, SQUARE));
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
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point p) {
        if ((x < p.x) || (x == p.x && y < p.y)) {
            return -1;
        }
        return 1;
    }
}
