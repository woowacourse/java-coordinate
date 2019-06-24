package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Position implements Comparable<Position> {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;
    private static List<Position> positions = new ArrayList<>();
    private final int value;

    static {
        for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
            positions.add(new Position(i));
        }
    }

    private Position(int value) {
        this.value = value;
    }

    public static Position valueOf(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("좌표 범위를 초과했습니다.");
        }
        return positions.get(value);
    }

    public int minus(Position another) {
        return value - another.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position another) {
        return Integer.compare(value, another.value);
    }
}
