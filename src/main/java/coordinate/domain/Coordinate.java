package coordinate.domain;

import java.util.List;
import java.util.Objects;

public class Coordinate {
    private final X x;
    private final Y y;

    public Coordinate(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public double findLength(Coordinate coordinate) {
        return Math.sqrt(Math.pow(x.sub_Point(coordinate.x), 2) + Math.pow(y.sub_Point(coordinate.y), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
