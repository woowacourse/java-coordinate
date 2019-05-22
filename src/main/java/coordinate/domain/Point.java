package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int MIN_X_VALUE = 0;
    private static final int MAX_X_VALUE = 24;
    private static final int MIN_Y_VALUE = 0;
    private static final int MAX_Y_VALUE = 24;
    private static final int BIGGER = 1;
    private static final int SAME = 0;
    private static final int SMALLER = -1;

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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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

    @Override
    /**
     * x 축 우선, y 축 차선으로 두 점을 비교하는 메서드
     */
    public int compareTo(Point another) {
        if (x > another.getX()) {
            return BIGGER;
        }

        if (x < another.getX()) {
            return SMALLER;
        }

        if (y > another.getY()) {
            return BIGGER;
        }

        if (y < another.getY()) {
            return SMALLER;
        }

        return SAME;
    }
}