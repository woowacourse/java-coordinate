package coordinate.domain;

import java.util.Objects;

public class Coordinate {
    private static final int MAX_BOUND = 24;
    private static final int MIN_BOUND = 0;

    private final int coordinate;

    private Coordinate(final int coordinate) {
        if (coordinate < MIN_BOUND || coordinate > MAX_BOUND) {
            throw new IllegalArgumentException();
        }
        this.coordinate = coordinate;
    }

    public static Coordinate of(final int coordinate) {
        return new Coordinate(coordinate);
    }

    public int value() {
        return coordinate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinate coordinate = (Coordinate) o;
        return this.coordinate == coordinate.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
