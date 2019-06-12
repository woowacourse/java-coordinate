package coordinatecalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Point implements Figure, Comparable<Point> {
    private static final int UNDER_LIMIT = 1;
    private static final int UPPER_LIMIT = 24;
    private static final String ERROR_LIMIT_OVER = "좌표 범위를 초과하였습니다.";

    private int x;
    private int y;

    Point(int x, int y) {
        if (isLimitOver(x) || isLimitOver(y)) {
            throw new IllegalArgumentException(ERROR_LIMIT_OVER);
        }

        this.x = x;
        this.y = y;
    }

    Point(List<Point> points) {
        this(points.get(0).getX(), points.get(0).getY());
    }

    private boolean isLimitOver(int x) {
        return (x > UPPER_LIMIT || x < UNDER_LIMIT);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public String getName() {
        return "Point";
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public List<Point> getPoints() {
        List<Point> result = new ArrayList<>();
        result.add(this);
        return result;
    }

    public double getDistance(Point anotherPoint) {
        double x = minusAndPow(this.x, anotherPoint.x);
        double y = minusAndPow(this.y, anotherPoint.y);
        return Math.sqrt(x + y);
    }

    @Override
    public int getPointsCount() {
        return 1;
    }

    private double minusAndPow(int x1, int x2) {
        return Math.pow((x2 - x1), 2);
    }

    @Override
    public int compareTo(Point another) {
        return Comparator
                .comparingInt(Point::getX)
                .thenComparingInt(Point::getY)
                .compare(this, another);
    }

    @Override
    public String toString() {
        return this.getName() + ": {x: " + this.x + ", y: " + this.y + "}";
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
