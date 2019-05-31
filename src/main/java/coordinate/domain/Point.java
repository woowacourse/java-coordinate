package coordinate.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private static final int BIGGER = 1;
    private static final int SAME = 0;
    private static final int SMALLER = -1;

    private final Position x;
    private final Position y;

    public Point(int x, int y) {
        this.x = Position.valueOf(x);
        this.y = Position.valueOf(y);
    }

    public int minusX(Point another) {
        return x.minus(another.x);
    }

    public int minusY(Point another) {
        return y.minus(another.y);
    }

    public int getX() {
        return this.x.getValue();
    }

    public int getY() {
        return this.y.getValue();
    }

    @Override
    /**
     * x 축 우선, y 축 차선으로 두 점을 비교하는 메서드
     */
    public int compareTo(Point another) {
        if (x.compareTo(another.x) > 0) {
            return BIGGER;
        }
        if (x.compareTo(another.x) < 0) {
            return SMALLER;
        }
        if (y.compareTo(another.y) > 0) {
            return BIGGER;
        }
        if (y.compareTo(another.y) < 0) {
            return SMALLER;
        }
        return SAME;
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
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}