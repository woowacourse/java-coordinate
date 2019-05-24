package coordinate.model;

import java.util.Objects;

public class Value {
    private final int value;
    
    public Value(int value) {

        checkValue(value);
        this.value = value;
    }

    private void checkValue(int value) {
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return value;
    }

    double rateSquared(Value value) {
        return Math.pow(getRateOfChange(value), 2);
    }

    double getRateOfChange(Value value) {
        return this.value - value.value;
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
