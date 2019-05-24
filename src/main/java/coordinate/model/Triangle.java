package coordinate.model;

import java.util.List;
import java.util.Objects;

public class Triangle extends AbstractFigure{

    public Triangle(List<Point> points) {
        super(points);
        validateTriangle(points);
    }

    private void validateTriangle(List<Point> points) {
        if (points.get(0).getSlope(points.get(1)) == points.get(0).getSlope(points.get(2))) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Point> getPoints() {
        return null;
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public double distance(int originPoint, int destinationPoint) {
        return points.get(originPoint).calculate(points.get(destinationPoint));
    }

    @Override
    public double area() {
        double a = distance(0,1);
        double b = distance(1,2);
        double c = distance(2,0);
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
