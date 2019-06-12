package coordinate.domain.point;

import java.util.Objects;

public class Point implements Comparable<Point> {
    public static final int MIN_X_VALUE = 0;
    public static final int MAX_X_VALUE = 24;
    public static final int MIN_Y_VALUE = 0;
    public static final int MAX_Y_VALUE = 24;
    private static final int COMPARE_BIG_POINT = 1;
    private static final int COMPARE_SAME_POINT = 0;
    private static final int COMPARE_SMALL_POINT = -1;

    private final int x;
    private final int y;

    public Point(int x, int y) {
        validateX(x);
        validateY(y);
        this.x = x;
        this.y = y;
    }

    public static Point of(String value) {
        String[] values = value.split(",");
        return new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    private void validateY(int y) {
        if (y < MIN_Y_VALUE || y > MAX_Y_VALUE) {
            throw new InvalidPointException("y 의 범위는 " + MIN_Y_VALUE + "이상 "
                    + MAX_Y_VALUE + "이하여야 합니다.");
        }
    }

    private void validateX(int x) {
        if (x < MIN_X_VALUE || x > MAX_X_VALUE) {
            throw new InvalidPointException("x 의 범위는 " + MIN_X_VALUE + "이상 "
                    + MAX_X_VALUE + "이하여야 합니다.");
        }
    }

    public double calculateDistance(Point point) {
        int xDistance = calculateXDistance(point);
        int yDistance = calculateYDistance(point);
        return Math.sqrt(square(xDistance) + square(yDistance));
    }

    public int calculateXDistance(Point point) {
        return this.x - point.x;
    }

    public int calculateYDistance(Point point) {
        return this.y - point.y;
    }

    private int square(int number) {
        return number * number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    public int compareTo(Point point) {
        if (x > point.x) {
            return COMPARE_BIG_POINT;
        }

        if (x < point.x) {
            return COMPARE_SMALL_POINT;
        }

        if (y > point.y) {
            return COMPARE_BIG_POINT;
        }

        if (y < point.y) {
            return COMPARE_SMALL_POINT;
        }

        return COMPARE_SAME_POINT;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}