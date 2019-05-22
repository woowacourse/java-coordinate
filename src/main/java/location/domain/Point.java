package location.domain;

import java.util.Objects;

public class Point {
    private static final String NOT_POSITIVE_MSG = "음수는 가능하지 않습니다.";
    private static final String OVER_24_MSG = "24를 넘습니다.";

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        isValid(x, y);
        this.x = x;
        this.y = y;
    }

    private void isValid(final int x, final int y) {
        isOver24(x, y);
        isPositive(x, y);
    }

    private void isPositive(final int x, final int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_MSG);
        }
    }

    private void isOver24(final int x, final int y) {
        if (x > 24 || y > 24) {
            throw new IllegalArgumentException(OVER_24_MSG);
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
