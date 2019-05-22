package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle implements Figure {
    private final Points points;

    public Triangle(Points points) {
        this.points = points;
    }

    @Override
    public double calculateResult() {
        // TODO: Refactoring - combination
        List<Point> points = this.points.getPoints();
        double side1 = calculateLength(points.get(0), points.get(1));
        double side2 = calculateLength(points.get(1), points.get(2));
        double side3 = calculateLength(points.get(2), points.get(0));
        double s = (side1 + side2 + side3) / 2;

        // TODO 일직선일 때 예외

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double calculateLength(Point p1, Point p2) {
        int x = Math.abs(p2.getX() - p1.getX());
        int y = Math.abs(p2.getY() - p1.getY());

        return Math.sqrt(x * x + y * y);
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
