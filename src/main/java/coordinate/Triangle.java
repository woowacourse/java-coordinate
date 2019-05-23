package coordinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Triangle {
    private List<Point> points;

    public Triangle(List<Point> points) {
        validateTriangle(points);
        this.points = points;
    }

    private void validateTriangle(List<Point> points) {
        if (points.get(0).getSlope(points.get(1)) == points.get(0).getSlope(points.get(2))) {
            throw new IllegalArgumentException();
        }
    }

    public double findArea() {
        double a = points.get(0).calculate(points.get(1));
        double b = points.get(1).calculate(points.get(2));
        double c = points.get(2).calculate(points.get(0));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
//        List<Double> distances = new ArrayList<>();
//        distances.add(points.get(0).calculate(points.get(1)));
//        distances.add(points.get(1).calculate(points.get(2)));
//        distances.add(points.get(2).calculate(points.get(0)));
//        double s = distances.stream().mapToDouble(i->i).sum() / 2;
//
//        return Math.sqrt(s*(s-distances.get(0))*(s-distances.get(1))*(s-distances.get(2)));
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
