package coordinatecalculator.domain;

import java.util.Objects;

public class Point {
    private final X x;
    private final Y y;

    public Point(String x, String y) {
        this.x = new X(x);
        this.y = new Y(y);
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
