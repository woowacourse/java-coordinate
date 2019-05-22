package coordinatecalculator;

import java.util.Comparator;
import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int UNDER_LIMIT = 1;
    private static final int UPPER_LIMIT = 24;
    private static final String ERROR_LIMIT_OVER = "좌표 범위를 초과하였습니다.";

    private int x;
    private int y;

    public Point(int x, int y) {
        //        if (isLimitOver(x) || isLimitOver(y)) {
        //            throw new IllegalArgumentException(ERROR_LIMIT_OVER);
        //        } // 처리 과정 중에 이 값을 넘어서는 경우가 있다. 일단 주석처리.

        this.x = x;
        this.y = y;
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

    public double getDistance(Point anotherPoint) {
        double x = minusAndPow(this.x, anotherPoint.x);
        double y = minusAndPow(this.y, anotherPoint.y);
        return Math.sqrt(x + y);
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

    public int compareToReverse(Point another) {
        return Comparator
                .comparingInt(Point::getX)
                .thenComparingInt(Point::getY)
                .reversed()
                .compare(this, another);
    }

    @Override
    public String toString() {
        return "{x: " + this.x + ", y: " + this.y + "}";
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
