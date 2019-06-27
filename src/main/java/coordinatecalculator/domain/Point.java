package coordinatecalculator.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final AxisValue x;
    private final AxisValue y;

    public Point(String x, String y) {
        this.x = AxisValue.getInstance(x);
        this.y = AxisValue.getInstance(y);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    double differenceBetween(Point point) {
        int dx = this.differenceByX(point);
        int dy = this.differenceByY(point);

        return Math.sqrt(dx * dx + dy * dy);
    }

    int differenceByX(Point point) {
        return this.x.differenceBy(point.x);
    }

    int differenceByY(Point point) {
        return this.y.differenceBy(point.y);
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
