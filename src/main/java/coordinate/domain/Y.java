package coordinate.domain;

import java.util.Objects;

public class Y {
    private final int coordinate;

    public Y(final int coordinate) {
        if (coordinate < 0 || coordinate > 24) {
            throw new IllegalArgumentException();
        }
        this.coordinate = coordinate;
    }

    public int value() {
        return coordinate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Y y = (Y) o;
        return coordinate == y.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
