package coordinate.domain;

import java.util.Objects;

public class Point {
    private Scala x;
    private Scala y;

    public Point(Scala x, Scala y) {
        this.x = x;
        this.y = y;
    }

    double getLength(Point point) {
        return Math.sqrt(Math.pow(x.subScala(point.x), 2) + Math.pow(y.subScala(point.y), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x.equals(point.x) &&
                y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
