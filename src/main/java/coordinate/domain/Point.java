package coordinate.domain;

import java.util.Objects;

public class Point {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "값이 범위를 벗어났습니다. 좌표 : (%d, %d)";

    private final int x;
    private final int y;

    public Point(int x, int y) {
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateRange(int x, int y) {
        if (x < MIN_COORDINATE || x > MAX_COORDINATE) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE, x, y));
        }
        if (y < MIN_COORDINATE || y > MAX_COORDINATE) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE, x, y));
        }
    }

    int getX() {
        return x;
    }

    int getY() {
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
