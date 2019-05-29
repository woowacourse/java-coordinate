package coordinate.domain;

import java.util.Objects;

public class Value {
    private static final int MAX_VALUE = 24;
    private static final int MIN_VALUE = 0;

    private final int num;

    public Value(final int num) {
        validate(num);
        this.num = num;
    }

    private void validate(final int num) {
        if (num > MAX_VALUE || num < MIN_VALUE) {
            throw new IllegalArgumentException("x의 좌표값은 " + MIN_VALUE + "이상 " + MAX_VALUE + "이하 입니다.");
        }
    }

    public int getAbs(final Value value) {
        return num - value.getNum();
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return num == value.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
