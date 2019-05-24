package coordinatecalculator.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final X x;
    private final Y y;

    public Point(String x, String y) {
        this.x = new X(x);
        this.y = new Y(y);
    }

    public int getX() {
        return x.getX();
    }

    public int getY() {
        return y.getY();
    }

    @Override
    public int compareTo(Point point) {
        return (this.getX() < point.getX()) ? -1 : ((this.getX() == point.getX()) ? Integer.compare(this.getY(), point.getY()) : 1);
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
