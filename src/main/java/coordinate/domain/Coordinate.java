package coordinate.domain;

import java.util.Objects;

public abstract class Coordinate {
    private final int coordinate;

    Coordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    int getDifference(Coordinate coordinate) {
        return coordinate.getDifference(this.coordinate);
    }

    int getDifference(int coordinate) {
        return Math.abs(coordinate - this.coordinate);
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