package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;
import java.util.Objects;

public class Triangle implements Figure {
    private final Points points;

    public Triangle(Points points) {
        this.points = points;

        // TODO: Refactoring
        List<Point> points1 = this.points.getPoints();
        Point point1 = points1.get(0);
        Point point2 = points1.get(1);
        Point point3 = points1.get(2);


        if (point1.getX() == point2.getX() && point2.getX() == point3.getX()) {
            throw new IllegalArgumentException("세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.");
        }

        int x = point1.getX() - point2.getX();
        int y = point1.getY() - point2.getY();
        int x1 = point3.getX() - point2.getX();
        int y1 = point3.getY() - point2.getY();

        if ((double)y / x == (double)y1 / x1) {
            throw new IllegalArgumentException("세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.");
        }
    }

    @Override
    public double calculateResult() {
        // TODO: Refactoring - combination
        List<Point> points = this.points.getPoints();
        double side1 = calculateLength(points.get(0), points.get(1));
        double side2 = calculateLength(points.get(1), points.get(2));
        double side3 = calculateLength(points.get(2), points.get(0));
        double s = (side1 + side2 + side3) / 2;
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
