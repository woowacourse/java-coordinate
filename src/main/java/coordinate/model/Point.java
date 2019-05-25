package coordinate.model;

import java.util.Objects;

public class Point implements Comparable<Point> {

    private PointNumber x;
    private PointNumber y;

    public Point(int x, int y) {
        this.x = PointNumber.get(x);
        this.y = PointNumber.get(y);
    }

    public double getDistance(Point anotherPoint) {
        return Math.sqrt(Math.pow(this.x.minus(anotherPoint.x), 2)
                + Math.pow(this.y.minus(anotherPoint.y), 2));
    }

    public double getIncline(Point anotherPoint) {
        if (this.x.equals(anotherPoint.x)) {
            return Double.MAX_VALUE;
        }
        return (double) (anotherPoint.y.minus(this.y)) / (anotherPoint.x.minus(this.x));
    }

    public boolean isEqualX(Point anotherPoint) {
        return this.x.equals(anotherPoint.x);
    }

    public boolean isEqualY(Point anotherPoint) {
        return this.y.equals(anotherPoint.y);
    }

    public PointNumber getX() {
        return x;
    }

    public PointNumber getY() {
        return y;
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
}
