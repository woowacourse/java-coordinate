package coordinate;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int MIN_X_VALUE = 0;
    private static final int MAX_X_VALUE = 24;
    private static final int MIN_Y_VALUE = 0;
    private static final int MAX_Y_VALUE = 24;
    private static final int COMPARE_BIG_POINT = 1;
    private static final int COMPARE_SAME_POINT = 0;
    private static final int COMPARE_SMALL_POINT = -1;

    private final int xValue;
    private final int yValue;

    public Point(int x, int y) {
        validateX(x);
        validateY(y);
        this.xValue = x;
        this.yValue = y;
    }

    private void validateY(int y) {
        if (y < MIN_Y_VALUE || y > MAX_Y_VALUE) {
            throw new IllegalArgumentException("yValue 의 범위는 " + MIN_Y_VALUE + "이상 "
                    + MAX_Y_VALUE + "이하여야 합니다.");
        }
    }

    private void validateX(int x) {
        if (x < MIN_X_VALUE || x > MAX_X_VALUE) {
            throw new IllegalArgumentException("xValue 의 범위는 " + MIN_X_VALUE + "이상 "
                    + MAX_X_VALUE + "이하여야 합니다.");
        }
    }

    public int getXValue() {
        return this.xValue;
    }

    public int getYValue() {
        return this.yValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return xValue == point.xValue &&
                yValue == point.yValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xValue, yValue);
    }

    @Override
    public int compareTo(Point another) {
        if (xValue > another.getXValue()) {
            return COMPARE_BIG_POINT;
        }

        if (xValue < another.getXValue()) {
            return COMPARE_SMALL_POINT;
        }

        if (yValue > another.getYValue()) {
            return COMPARE_BIG_POINT;
        }

        if (yValue < another.getYValue()) {
            return COMPARE_SMALL_POINT;
        }

        return COMPARE_SAME_POINT;
    }
}