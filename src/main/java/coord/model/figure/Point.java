package coord.model.figure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Point {
    private final List<Coord> coords;

    public Point(int x, int y) {
        coords = Collections.unmodifiableList(Arrays.asList(new Coord(x), new Coord(y)));
    }

    public int x() {
        return coords.get(0).get();
    }

    public int y() {
        return coords.get(1).get();
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