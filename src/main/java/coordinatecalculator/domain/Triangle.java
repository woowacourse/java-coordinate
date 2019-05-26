package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;
import java.util.Objects;

public class Triangle implements Figure {
    private static final String INVALID_TRIANGLE_MESSAGE = "세 점이 일직선 상에 위치할 수는 없습니다. 다시 입력해주세요.";
    private static final String RECTANGLE_RESULT_MESSAGE = "사각형 넓이는 ";

    private final Points points;

    Triangle(Points points) {
        checkStraightLine(points);
        this.points = points;
    }

    private void checkStraightLine(Points points) {
        List<Point> sortedPoints = points.getSortedPoints();
        Point leftPoint = sortedPoints.get(0);
        Point middlePoint = sortedPoints.get(1);
        Point rightPoint = sortedPoints.get(2);

        checkSameXLocation(sortedPoints);

        double slope1 = makeSlope(leftPoint, middlePoint);
        double slope2 = makeSlope(middlePoint, rightPoint);

        if (slope1 == slope2) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    private void checkSameXLocation(List<Point> sortedPoints) {
        Point leftPoint = sortedPoints.get(0);
        Point middlePoint = sortedPoints.get(1);
        Point rightPoint = sortedPoints.get(2);
        if (leftPoint.getX() == middlePoint.getX() && middlePoint.getX() == rightPoint.getX()) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_MESSAGE);
        }
    }

    private double makeSlope(Point left, Point right) {
        return ((double) left.getY() - right.getY()) / (left.getX() - right.getX());
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();
        double side1 = calculateLength(points.get(0), points.get(1));
        double side2 = calculateLength(points.get(1), points.get(2));
        double side3 = calculateLength(points.get(2), points.get(0));
        double s = (side1 + side2 + side3) / 2;
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
