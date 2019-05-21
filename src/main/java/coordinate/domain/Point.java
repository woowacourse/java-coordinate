package coordinate.domain;

import java.util.Objects;

public class Point {
    private final X x;
    private final Y y;

    public Point(final int x, final int y) {
        this.x = new X(x);
        this.y = new Y(y);
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
