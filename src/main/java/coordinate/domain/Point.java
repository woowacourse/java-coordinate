package coordinate.domain;

import java.util.Objects;

public class Point {

    private final Number x;
    private final Number y;

    private Point(Number x, Number y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            throw new IllegalArgumentException("아무것도 입력되지 않았습니다.");
        }

        this.x = x;
        this.y = y;
    }

    public static Point create(int x, int y) {
        return new Point(Number.create(x), Number.create(y));
    }

    public double getDistance(Point point) {
        double calculationX = Math.pow(x.subtract(point.getX()), 2);
        double calculationY = Math.pow(y.subtract(point.getY()), 2);

        return Math.sqrt(calculationX + calculationY);
    }

    private Number getX() {
        return x;
    }

    private Number getY() {
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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
