package coordinate.domain;

import java.util.Objects;

public class Number {
    private static final String ERROR_BOUNDARY = "잘못된 범위의 수가 입력되었습니다.";
    private static final int MIN = 0;
    private static final int MAX = 24;

    private final int number;

    private Number(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ERROR_BOUNDARY);
        }

        this.number = number;
    }

    public static Number create(int number) {
        return new Number(number);
    }

    public int getNumber() {
        return this.number;
    }

    int subtract(Number otherNumber) {
        return number - otherNumber.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
