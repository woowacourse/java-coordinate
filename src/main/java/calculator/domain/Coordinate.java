package calculator.domain;

import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-29
 */
public class Coordinate {
    private static final String EX_COORDINATE_RANGE_MESSAGE = "좌표 범위는 0~24 사이입니다.";
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;
    private final int coordinate;

    public Coordinate(int coordinate) {
        this.coordinate = coordinate;
        checkCoordinateCondition();
    }

    private void checkCoordinateCondition() {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_COORDINATE_RANGE_MESSAGE);
        }
    }

    public int value() {
        return this.coordinate;
    }

    public int difference(Coordinate operand) {
        return Math.abs(this.coordinate - operand.value());
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
