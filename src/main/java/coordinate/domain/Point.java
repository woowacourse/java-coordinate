package coordinate.domain;

import java.util.Objects;

public class Point {
    public static final int MIN_POINT = 0;
    public static final int MAX_POINT = 24;

    private final Integer x;
    private final Integer y;

    private Point(final Integer x, final Integer y) {
        validate(x);
        validate(y);
        this.x = x;
        this.y = y;
    }

    public static Point of(final Integer x, final Integer y) {
        return new Point(x, y);
    }

    private void validate(final int x) {
        if (x < MIN_POINT || x > MAX_POINT) {
            throw new IllegalArgumentException("정상적인 좌표값을 입력하세요");
        }
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public Boolean isSameX(Point other) {
        return Objects.equals(this.x, other.x);
    }

    public Boolean isSameY(Point other) {
        return Objects.equals(this.y, other.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point other = (Point) o;
        return (this.x == other.x) && (this.y == other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
