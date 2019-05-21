package coordinate.domain;

import java.util.Objects;

public class Point {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 24;

    final int x;
    final int y;

    public Point(int x, int y) {
        validateNumberRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateNumberRange(int x, int y) {
        validateMinRange(x, y);
        validateMaxRange(x, y);
    }

    private void validateMaxRange(int x, int y) {
        if (x > MAX_VALUE || y > MAX_VALUE) {
            throw new IllegalArgumentException("좌표 값은 " + MAX_VALUE + "보다 작거나 같아야 합니다 ");
        }
    }

    private void validateMinRange(int x, int y) {
        if (x < MIN_VALUE || y < MIN_VALUE) {
            throw new IllegalArgumentException("좌표 값은 " + MIN_VALUE + "보다 크거나 같아야 합니다.");
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

    public int getDeltaXTo(Point point) {
        return Math.abs(this.x - point.x);
    }

    public int getDeltaYTo(Point point) {
        return Math.abs(this.y - point.y);
    }
}
