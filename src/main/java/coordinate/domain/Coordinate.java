package coordinate.domain;

import java.util.Objects;

public class Coordinate {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;

    private final int coordinate;

    public Coordinate(int coordinate) {
        this.coordinate = coordinate;
        validateCoordinateRange(coordinate);
    }

    private void validateCoordinateRange(int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException("좌표는 0과 24 사이의 값이여야 합니다.");
        }
    }

    int getDistance(Coordinate endPointCoordinate) {
        return endPointCoordinate.coordinate - this.coordinate;
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
