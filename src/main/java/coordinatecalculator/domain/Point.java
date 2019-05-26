package coordinatecalculator.domain;

import java.util.Objects;

import static java.lang.Math.*;

public class Point implements Comparable<Point> {
    private static final int SQUARE_VALUE = 2;
    private static final int LIMIT_MINIMUM_NUM = 0;
    private static final int LIMIT_MAXIMUM_NUM = 24;
    private static final double STRAIGHT_ANGLE = 180;
    private static final String ERROR_OUT_RANGE_COORDINATE = "입력된 좌표 범위가 올바르지 않습니다.";
    private static final int DOUBLE = 2;
    private static final int TRUE = 1;
    private static final int FALSE = -1;

    private final int x;
    private final int y;

    private Point(final int x, final int y) {
        checkValidRangeXY(x, y);
        this.x = x;
        this.y = y;
    }

    private void checkValidRangeXY(final int x, final int y) {
        if (isOutRange(x) || isOutRange(y)) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_COORDINATE);
        }
    }

    private boolean isOutRange(final int number) {
        return number < LIMIT_MINIMUM_NUM || number > LIMIT_MAXIMUM_NUM;
    }

    public static Point of(final int x, final int y) {
        return new Point(x, y);
    }

    public double getDistance(final Point anotherPoint) {
        int dX = this.x - anotherPoint.x;
        int dY = this.y - anotherPoint.y;

        return sqrt(square(dX) + square(dY));
    }

    private double square(final double number) {
        return pow(number, SQUARE_VALUE);
    }

    double getAngle(final Point point2, final Point point3) {
        double a = sqrt(square(this.x - point3.x) + square(this.y - point3.y));
        double b = sqrt(square(this.x - point2.x) + square(this.y - point2.y));
        double c = sqrt(square(point2.x - point3.x) + square(point2.y - point3.y));

        double Angle = acos((square(b) + square(c) - square(a)) / (DOUBLE * b * c));
        return Angle * STRAIGHT_ANGLE / PI;
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

    @Override
    public int compareTo(final Point o) {
        return this.x < o.x ? FALSE : this.x > o.x ? TRUE : this.y < o.y ? FALSE : TRUE;
    }
}
