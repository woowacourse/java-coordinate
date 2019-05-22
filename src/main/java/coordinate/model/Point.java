package coordinate.model;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private PointNumber x;
    private PointNumber y;

    public Point(PointNumber x, PointNumber y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point point2) {
        return Math.sqrt(Math.pow(this.x.getNumber() - point2.x.getNumber(), 2)
                + Math.pow(this.y.getNumber() - point2.y.getNumber(), 2));
    }

    public double getIncline(Point point) {
        if (point.x.getNumber() == this.x.getNumber()) {
            return Integer.MAX_VALUE;
        }
        return (double) (point.y.getNumber() - this.y.getNumber()) / (point.x.getNumber() - this.x.getNumber());
    }

    public boolean isEqualX(Point anotherPoint) {
        return this.x.getNumber() == anotherPoint.x.getNumber();
    }

    public boolean isEqualY(Point anotherPoint) {
        return this.y.getNumber() == anotherPoint.y.getNumber();
    }

    @Override
    public int compareTo(Point o) {
        if (x.getNumber() == o.x.getNumber()) {
            return y.getNumber() - o.y.getNumber();
        }
        return x.getNumber() - o.x.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x.equals(point.x) &&
                y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public PointNumber getX() {
        return x;
    }

    public PointNumber getY() {
        return y;
    }
}
