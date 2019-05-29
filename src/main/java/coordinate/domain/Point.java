package coordinate.domain;

import java.util.Objects;

public class Point {
    static final int MIN_X = 0;
    static final int MAX_X = 24;
    static final int MIN_Y = 0;
    static final int MAX_Y = 24;

    private final NumberForPoint x;
    private final NumberForPoint y;

    public Point(int x, int y) {
        this.x = NumberForPoint.valueOf(x);
        this.y = NumberForPoint.valueOf(y);
    }

    int getX() {
        return x.getValue();
    }

    int getY() {
        return y.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    double linearlyIntegrateWithYto(Point p2) {
        return (x + p2.getX()) * (y - p2.getY()) / 2;
    }
}
