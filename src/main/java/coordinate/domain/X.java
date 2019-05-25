package coordinate.domain;

import java.util.Objects;

public class X {
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final int MIN_COORDINATE_VALUE = 1;

    private int coordinate;

    public X(int coordinate) {
        checkCoordinateValue(coordinate);
        this.coordinate = coordinate;
    }

    private void checkCoordinateValue(int coordinateValue) {
        if (coordinateValue < MIN_COORDINATE_VALUE || coordinateValue > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("X 좌표가 범위를 벗어났습니다.");
        }
    }

    public int getCoordinate() {
        return coordinate;
    }

    public int getDistance(X x) {
        return Math.abs(this.coordinate - x.coordinate);
    }

    public boolean compare(X x) {
        return this.coordinate < x.coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        X x = (X) o;
        return coordinate == x.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
