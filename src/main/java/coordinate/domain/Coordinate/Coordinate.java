package coordinate.domain.Coordinate;

public abstract class Coordinate {
    private static final int MAX_VALUE = 24;
    private static final int MIN_VALUE = 0;
    private final int value;

    public Coordinate(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value > MAX_VALUE || value < MIN_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24 이하의 정수만 가능합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
