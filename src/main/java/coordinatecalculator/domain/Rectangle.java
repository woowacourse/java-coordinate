package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
    private static final String INVALID_CHECK_MESSAGE = "직사각형이 아닙니다. 다시 입력해 주세요";
    private static final String TRIANGLE_RESULT_MESSAGE = "사각형 넓이는 ";

    private final Points points;

    private Rectangle(Points points) {
        this.points = points;

        checkValidRectangle();
    }

    public static Rectangle newInstance(Points points) {
        return new Rectangle(points);
    }

    private void checkValidRectangle() {
        List<Point> points = Collections.unmodifiableList(this.points.getSortedPoints());

        if (matchesPoint(points)) {
            throw new IllegalArgumentException(INVALID_CHECK_MESSAGE);
        }
    }

    private boolean matchesPoint(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);

        return !(matchesX(p1, p2) && matchesX(p3, p4) && matchesY(p1, p3) && matchesY(p2, p4));
    }

    private boolean matchesX(Point firstPoint, Point secondPoint) {
        return firstPoint.getX() == secondPoint.getX();
    }

    private boolean matchesY(Point firstPoint, Point secondPoint) {
        return firstPoint.getY() == secondPoint.getY();
    }

    @Override
    public double calculateResult() {
        List<Point> points = Collections.unmodifiableList(this.points.getSortedPoints());
        return Math.abs((points.get(0).getY() - points.get(1).getY()) * (points.get(2).getX() - points.get(0).getX()));
    }

    @Override
    public String makeResult() {
        return TRIANGLE_RESULT_MESSAGE + calculateResult();
    }

    @Override
    public Points getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
