package coordinate.domain;

import java.util.Objects;

class Coordinate {
    private static final int MIN_POINT_NUMBER = 0;
    private static final int MAX_POINT_NUMBER = 24;

    private final int coordinate;

    Coordinate(int coordinate) {
        checkPoint(coordinate);
        this.coordinate = coordinate;
    }

    int subCoordinate(Coordinate other) {
        return (this.coordinate - other.coordinate);
    }

    private void checkPoint(int number) {
        if (isNotAllowedNumber(number)) {
            throw new IllegalArgumentException("0 이상 24 이하의 수를 입력하세요.");
        }
    }

    private boolean isNotAllowedNumber(int number) {
        return (number > MAX_POINT_NUMBER || number < MIN_POINT_NUMBER);
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
