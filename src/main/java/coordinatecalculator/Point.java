package coordinatecalculator;

import java.util.Objects;

import static java.lang.Math.*;

class Point implements Comparable<Point> {
    private static final int SQUARE_VALUE = 2;
    private static final int LIMIT_MINIMUM_NUM = 0;
    private static final int LIMIT_MAXIMUM_NUM = 24;
    private static final String ERROR_RANGE_COORDINATE = "입력된 좌표 범위가 올바르지 않습니다.";
    private static final double STRAIGHT_ANGLE = 180;

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

        return sqrt(square(dX) + square(dY));
    }

    private double square(double number) {
        return pow(number, SQUARE_VALUE);
    }

    public double getAngle(Point point2, Point point3) {
        double a = sqrt(square(this.x - point3.x) + square(this.y - point3.y));
        double b = sqrt(square(this.x - point2.x) + square(this.y - point2.y));
        double c = sqrt(square(point2.x - point3.x) + square(point2.y - point3.y));

        double Angle = acos((square(b) + square(c) - square(a)) / (2 * b * c));
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
    public int compareTo(Point o) {
        return this.x < o.x ? -1 : this.x > o.x ? 1 : this.y < o.y ? -1 : 1;
    }
}
