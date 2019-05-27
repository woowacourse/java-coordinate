package coordinatecalculator.domain;

import java.util.Objects;

public class CoordinatePoint {
    private static final int MAX_BOUND = 24;
    private static final int MIN_BOUND = 1;

    private int coordinatePoint;

    CoordinatePoint(int coordinatePoint) {
        checkCoordinatePoint(coordinatePoint);
        this.coordinatePoint = coordinatePoint;
    }

    private void checkCoordinatePoint(int coordinatePoint) {
        if (coordinatePoint > MAX_BOUND || coordinatePoint < MIN_BOUND) {
            throw new IllegalArgumentException(" 범위를 제대로 입력하세요. ");
        }
    }

    public int getCoordinate() {
        return coordinatePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinatePoint that = (CoordinatePoint) o;
        return coordinatePoint == that.coordinatePoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinatePoint);
    }
}
