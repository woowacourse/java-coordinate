package coord.model.figure;

import java.util.Objects;

public final class Point {
    private final Coord x;
    private final Coord y;

    public Point(int x, int y) {
        this.x = Coord.of(x);
        this.y = Coord.of(y);
    }

    public int x() {
        return x.val();
    }

    public int y() {
        return y.val();
    }

    @Override
    public String toString() {
        return "(" + x() + ", " + y() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point rhs = (Point) o;
        return x() == rhs.x() && y() == rhs.y();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x(), y());
    }
}