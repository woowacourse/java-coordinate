package coordinate.domain.point;

import java.util.Objects;

public class Coordinate {
    private static final int MAX_VALUE = 24;
    private static final int MIN_VALUE = 0;

    private final int value;

    Coordinate(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24 이하의 정수만 가능합니다.");
        }
    }

    public int differenceFrom(Coordinate coordinate) {
        return coordinate.value - value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate point = (Coordinate) o;
        return point.value == value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
