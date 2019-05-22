package coordinate;

import java.util.Objects;

public class Value {
    private final int value;
    
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
}
