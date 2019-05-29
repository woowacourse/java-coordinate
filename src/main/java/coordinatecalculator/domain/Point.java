package coordinatecalculator.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final AxisValue x;
    private final AxisValue y;

    public Point(String x, String y) {
        this.x = new AxisValue(x);
        this.y = new AxisValue(y);
    }

    public int getAxisValue() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    @Override
    public int compareTo(Point point) {
        return (this.getAxisValue() < point.getAxisValue()) ? -1 : ((this.getAxisValue() == point.getAxisValue()) ? Integer.compare(this.getY(), point.getY()) : 1);
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
