package location.domain;

import java.util.Objects;

public class Point {
    private static final String NOT_POSITIVE_MSG = "음수는 가능하지 않습니다.";
    private static final String OVER_24_MSG = "24를 넘습니다.";
    private static final int MAX_NUMBER = 24;
    private static final int MIN_NUMBER = 0;
    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        checkValid(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkValid(final int x, final int y) {
        checkOver24(x, y);
        checkPositive(x, y);
    }

    private void checkOver24(final int x, final int y) {
        if (x > MAX_NUMBER || y > MAX_NUMBER) {
            throw new IllegalArgumentException(OVER_24_MSG);
        }
    }

    private void checkPositive(final int x, final int y) {
        if (x < MIN_NUMBER || y < MIN_NUMBER) {
            throw new IllegalArgumentException(NOT_POSITIVE_MSG);
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
