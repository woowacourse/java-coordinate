package coordinate.domain;

import java.util.Objects;

public class Y {
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final int MIN_COORDINATE_VALUE = 1;

    private int coordinate;

    public Y(int coordinate) {
        checkCoordinateValue(coordinate);
        this.coordinate = coordinate;
    }

    private void checkCoordinateValue(int coordinateValue) {
        if (coordinateValue < MIN_COORDINATE_VALUE || coordinateValue > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("Y 좌표가 범위를 벗어났습니다.");
        }
    }

    public int getCoordinate() {
        return coordinate;
    }

    public int getDistance(Y y) {
        return Math.abs(this.coordinate - y.coordinate);
    }

    public boolean compare(Y y) {
        return this.coordinate < y.coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Y y = (Y) o;
        return coordinate == y.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
