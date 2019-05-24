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
        checkValidRangeXY(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkValidRangeXY(int x, int y) {
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
        int dX = this.x - anotherPoint.x;
        int dY = this.y - anotherPoint.y;

        return sqrt(pow(dX, SQUARE_NUMBER) + pow(dY, SQUARE_NUMBER));
    }

    public double getAngle(Point anotherPoint) {
        int dX = this.x - anotherPoint.x;
        int dY = this.y - anotherPoint.y;

        double radian = Math.atan2(dX, dY);
        return (radian * 180) / Math.PI;
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
