package coordinate.domain;

import java.util.Objects;

public abstract class Coordinate {
    private final int coordinate;

    Coordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    int calculateDifference(Coordinate coordinate) {
        return Math.abs(this.coordinate - coordinate.coordinate);
    }

    int calculateDifference(int coordinate) {
        return Math.abs(this.coordinate - coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return coordinate == that.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}