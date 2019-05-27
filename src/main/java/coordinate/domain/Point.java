package coordinate.domain;

import java.util.Objects;

public class Point {
    private static final String ERROR_EMPTY = "아무것도 입력되지 않았습니다.";
    private static final int SQUARE_ROOT = 2;

    private final Number x;
    private final Number y;

    private Point(Number x, Number y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            throw new IllegalArgumentException(ERROR_EMPTY);
        }

        this.x = x;
        this.y = y;
    }

    public static Point create(int x, int y) {
        return new Point(Number.create(x), Number.create(y));
    }

    public boolean isEqualX(Point point) {
        return x.equals(point.getX());
    }

    public boolean isEqualY(Point point) {
        return y.equals(point.getY());
    }

    public double getDistance(Point point) {
        double calculationX = Math.pow(x.subtract(point.getX()), SQUARE_ROOT);
        double calculationY = Math.pow(y.subtract(point.getY()), SQUARE_ROOT);

        return Math.sqrt(calculationX + calculationY);
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
