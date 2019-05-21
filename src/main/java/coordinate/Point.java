package coordinate;

import java.util.Objects;

public class Point {
    private static final int MIN_X_VALUE = 0;
    private static final int MAX_X_VALUE = 24;
    private static final int MIN_Y_VALUE = 0;
    private static final int MAX_Y_VALUE = 24;

    private final int x;
    private final int y;

    public Point(int x, int y) {
        validateX(x);
        validateY(y);
        this.x = x;
        this.y = y;
    }

    private void validateY(int y) {
        if (y < MIN_Y_VALUE || y > MAX_Y_VALUE) {
            throw new IllegalArgumentException("y 의 범위는 " + MIN_Y_VALUE + "이상 "
                    + MAX_Y_VALUE + "이하여야 합니다.");
        }
    }

    private void validateX(int x) {
        if (x < MIN_X_VALUE || x > MAX_X_VALUE) {
            throw new IllegalArgumentException("x 의 범위는 " + MIN_X_VALUE + "이상 "
                    + MAX_X_VALUE + "이하여야 합니다.");
        }
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