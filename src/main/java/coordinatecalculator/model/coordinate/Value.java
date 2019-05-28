package coordinatecalculator.model.coordinate;

import java.util.Objects;

public class Value {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;

    private final int value;

    public Value(int value) {
        checkValueRange(value);
        this.value = value;
    }

    private void checkValueRange(int value) {
        if ((value < MIN_VALUE) || (value > MAX_VALUE)) {
            throw new IllegalArgumentException(MIN_VALUE + "에서 " + MAX_VALUE + "사이 값을 입력해주세요.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return value == value1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
