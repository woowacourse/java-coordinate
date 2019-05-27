package coordinate.domain;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        if (number < 0 || number > 24) {
            throw new IllegalArgumentException("아무것도 입력되지 않았습니다.");
        }

        this.number = number;
    }

    public static Number create(int number) {
        return new Number(number);
    }

    int subtract(Number otherNumber) {
        return number - otherNumber.getNumber();
    }

    public int getNumber() {
        return this.number;
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
