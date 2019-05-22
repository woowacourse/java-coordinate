package coordinatecalculator.model;


import java.util.Objects;

public class Point {
    private final XPoint xPoint;
    private final YPoint yPoint;

    public Point(String xPoint, String yPoint) {
        this.xPoint = new XPoint(xPoint);
        this.yPoint = new YPoint(yPoint);
    }

    public int square(Point anotherPoint) {
        return (int) (Math.pow(this.xPoint.subtract(anotherPoint.xPoint.getValue()), 2)
                + Math.pow(this.yPoint.subtract(anotherPoint.yPoint.getValue()), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(xPoint, point.xPoint) &&
                Objects.equals(yPoint, point.yPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }
}
