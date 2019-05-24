package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PointNumber {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 24;

    private static List<PointNumber> bucket = new ArrayList<>();

    static {
        for (int i = MIN_RANGE; i <= MAX_RANGE; i++) {
            bucket.add(new PointNumber(i));
        }
    }

    private int number;

    private PointNumber(int number) {
        this.number = number;
    }

    public static PointNumber create(int number) {
        checkValidRange(number);
        return bucket.get(number);
    }

    private static void checkValidRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException("좌표 숫자 입력 범위 오류");
        }
    }

    public int minus(PointNumber anotherPointNumber) {
        return this.number - anotherPointNumber.number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointNumber)) return false;
        PointNumber that = (PointNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
