package coordinatecalculator;

import java.util.Objects;

import static java.lang.Math.*;

class Point {
    private static final int SQUARE_NUMBER = 2;
    private static final int LIMIT_MINIMUM_NUM = 0;
    private static final int LIMIT_MAXIMUM_NUM = 24;
    private static final String ERROR_RANGE_COORDINATE = "입력된 좌표 범위가 올바르지 않습니다.";

    private final int x;
    private final int y;

    private Point(int x, int y) {
        checkValidXY(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkValidXY(int x, int y) {
        if (x < LIMIT_MINIMUM_NUM || x > LIMIT_MAXIMUM_NUM) {
            throw new IllegalArgumentException(ERROR_RANGE_COORDINATE);
        }

        if (y < LIMIT_MINIMUM_NUM || y > LIMIT_MAXIMUM_NUM) {
            throw new IllegalArgumentException();
        }
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public double getDistance(Point anotherPoint) {
        int deltaX = this.x - anotherPoint.x;
        int deltaY = this.y - anotherPoint.y;

        return sqrt(pow(deltaX, SQUARE_NUMBER) + pow(deltaY, SQUARE_NUMBER));
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        final Point point = (Point) another;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
