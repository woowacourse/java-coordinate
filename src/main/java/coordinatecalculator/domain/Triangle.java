package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Triangle implements Figure {
    private static final String INVALID_TRIANGLE_MESSAGE = "세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.";
    private static final String RECTANGLE_RESULT_MESSAGE = "삼각형 넓이는 ";
    private static final int HERON_NUMBER = 2;

    private final Points points;

    private Triangle(Points points) {
        this.points = points;

        checkValidTriangle();
    }

    public static Triangle newInstance(Points points) {
        return new Triangle(points);
    }

    private void checkValidTriangle() {
        List<Point> points = this.points.getSortedPoints();
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        checkOnSameXAxis(point1, point2, point3);
        checkOnSameExtension(point1, point2, point3);
    }

    private void checkOnSameXAxis(Point p1, Point p2, Point p3) {
        if (p1.getAxisValue() == p2.getAxisValue() && p2.getAxisValue() == p3.getAxisValue()) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    private void checkOnSameExtension(Point p1, Point p2, Point p3) {
        int x1 = p1.getAxisValue() - p2.getAxisValue();
        int y1 = p1.getY() - p2.getY();
        int x2 = p3.getAxisValue() - p2.getAxisValue();
        int y2 = p3.getY() - p2.getY();

        if ((double) y1 / x1 == (double) y2 / x2) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    @Override
    public double calculateResult() {
        List<Point> points = Collections.unmodifiableList(this.points.getSortedPoints());
        double side1 = calculateLength(points.get(0), points.get(1));
        double side2 = calculateLength(points.get(1), points.get(2));
        double side3 = calculateLength(points.get(2), points.get(0));
        double s = (side1 + side2 + side3) / HERON_NUMBER;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public String makeResult() {
        return RECTANGLE_RESULT_MESSAGE + calculateResult();
    }

    @Override
    public Points getPoints() {
        return this.points;
    }

    private double calculateLength(Point p1, Point p2) {
        int x = Math.abs(p2.getAxisValue() - p1.getAxisValue());
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
