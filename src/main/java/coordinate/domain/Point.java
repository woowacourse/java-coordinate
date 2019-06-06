package coordinate.domain;

import java.util.Objects;

public class Point {
    static final int MIN_X = 0;
    static final int MAX_X = 24;
    static final int MIN_Y = 0;
    static final int MAX_Y = 24;

    private final PointNumber x;
    private final PointNumber y;

    public Point(int x, int y) {
        this.x = PointNumber.valueOf(x);
        this.y = PointNumber.valueOf(y);
    }

    int getX() {
        return x.getValue();
    }

    int getY() {
        return y.getValue();
    }

    int minusX(Point point) {
        return x.minus(point.x);
    }

    int minusY(Point point) {
        return y.minus(point.y);
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

}
