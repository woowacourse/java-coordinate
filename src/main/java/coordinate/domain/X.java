package coordinate.domain;

import java.util.Objects;

public class X {
    private final int coordinate;

    public X(final int coordinate) {
        if (coordinate < 0 || coordinate > 24) {
            throw new IllegalArgumentException();
        }
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final X x = (X) o;
        return coordinate == x.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
