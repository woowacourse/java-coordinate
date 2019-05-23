package coordinate;

import java.util.List;
import java.util.Objects;

public class Value {
    private final double value;
    
    public Value(String input) {
        int value = Integer.parseInt(input);
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException();
        }
        this.value = value;
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

    public double message(Value value) {
        return Math.pow(getRateOfChange(value), 2);
    }

    public double getRateOfChange(Value value) {
        return this.value - value.value;
    }
}
