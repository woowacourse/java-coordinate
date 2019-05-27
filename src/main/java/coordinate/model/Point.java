package coordinate.model;

import java.util.Objects;

public class Point {
    private static final String ERROR_OUT_OF_POINT_RANGE
            = "잘못된 범위의 입력값입니다. 정수 범위는 " + Point.LOWER_LIMIT + " ~ " + Point.UPPER_LIMIT + " 사이의 수로 입력해 주세요.";
    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        checkRangeOf(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkRangeOf(int x, int y) {
        if (exceedRange(x) || exceedRange(y)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_POINT_RANGE);
        }
    }

    private boolean exceedRange(int coordinate) {
        return coordinate < LOWER_LIMIT || coordinate > UPPER_LIMIT;
    }

    public double calculateSlope(Point point) {
        if (this.x == point.x) {
            return Double.MAX_VALUE;
        }
        return Math.abs((double) (this.y - point.y) / (this.x - point.x));
    }

    public double calculateDistance(Point point) {
        return Math.sqrt(squareDifference(this.x, point.x)
                + squareDifference(this.y, point.y));
    }

    private double squareDifference(int firstValue, int secondValue) {
        return Math.pow(firstValue - secondValue, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSame(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
