package coordinate.domain.coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coordinate {
    private static final int MAX_VALUE = 24;
    private static final int MIN_VALUE = 0;

    private final int value;
    private static List<Coordinate> coordinates;

    static {
        coordinates = new ArrayList<>();
        for (int i = 0; i < MAX_VALUE + 1; i++) {
            coordinates.add(new Coordinate(i));
        }
    }

    public static Coordinate create(int value) {
        validateValue(value);
        return coordinates.get(value);
    }

    private Coordinate(int value) {
        this.value = value;
    }

    private static void validateValue(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24 이하의 정수만 가능합니다.");
        }
    }

    public int getDiffWith(Coordinate coordinate) {
        return coordinate.value - value;
    }

    public int getValue() {
        return value;
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
