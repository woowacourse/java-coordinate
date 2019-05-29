package coordinatecalculator.model.coordinate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Value {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 24;

    private static final Map<Integer, Value> valueBox = new HashMap<>();

    private final int value;

    private Value(int value) {
        checkValueRange(value);
        this.value = value;
    }

    private void checkValueRange(int value) {
        if ((value < MIN_VALUE) || (value > MAX_VALUE)) {
            throw new IllegalArgumentException(MIN_VALUE + "에서 " + MAX_VALUE + "사이 값을 입력해주세요.");
        }
    }

    public static Value assignValue(int value) {
        if (!valueBox.containsKey(value)) {
            valueBox.put(value, new Value(value));
        }
        return valueBox.get(value);
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
