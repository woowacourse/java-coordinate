package coordinatecalculator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Value {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 24;
    private static final Map<Integer, Value> values = new HashMap<>();

    private double value;

    static {
        for (int i = 0; i < 25; i++) {
            values.put(i, new Value(i));
        }
    }

    private Value(double value) {
        this.value = value;
    }

    public static Value retrieveValue(int key) {
        if (key < MINIMUM_VALUE || key > MAXIMUM_VALUE) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    public int getValue() {
        return (int) value;
    }

    public double getRateOfChange(Value destinationValue) {
        return this.value - destinationValue.value;
    }

    public double calculateSquared(Value otherValue) {
        return Math.pow(this.getRateOfChange(otherValue), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return Double.compare(value1.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
