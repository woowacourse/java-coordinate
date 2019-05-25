package coordinate.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Coordinate {
    private static final int MAX_BOUND = 24;
    private static final int MIN_BOUND = 0;

    private static Map<Integer, Coordinate> map = new HashMap<>();

    static {
        for (int i = MIN_BOUND; i <= MAX_BOUND; i++) {
            map.put(i, of(i));
        }
    }

    private final int coordinate;

    private Coordinate(final int coordinate) {
        if (coordinate < MIN_BOUND || coordinate > MAX_BOUND) {
            throw new IllegalArgumentException("좌표는 0~24만 입력 가능합니다.");
        }
        this.coordinate = coordinate;
    }

    public static Coordinate of(final int coordinate) {
        Coordinate instance = map.get(coordinate);
        if(map.get(coordinate)==null) {
            return new Coordinate(coordinate);
        }
        return instance;
    }

    public int value() {
        return coordinate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Coordinate coordinate = (Coordinate) o;
        return this.coordinate == coordinate.coordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }
}
