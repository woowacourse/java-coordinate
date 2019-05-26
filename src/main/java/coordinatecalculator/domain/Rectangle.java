package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Console;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure, Console {

    private final Points points;

    Rectangle(Points points) {
        checkValidRectangle(points);
        this.points = points;
    }

    private void checkValidRectangle(Points points) {
        List<Point> sortedPoints = points.getSortedPoints();

        checkXLocation(sortedPoints);
        checkYLocation(sortedPoints);
    }

    private void checkXLocation(List<Point> sortedPoints) {
        Point leftBottom = sortedPoints.get(0);
        Point leftTop = sortedPoints.get(1);
        Point rightBottom = sortedPoints.get(2);
        Point rightTop = sortedPoints.get(3);

        if (leftBottom.getX() != leftTop.getX() || rightBottom.getX() != rightTop.getX()) {
            throw new IllegalArgumentException(INVALID_CHECK_MESSAGE);
        }
    }

    private void checkYLocation(List<Point> sortedPoints) {
        Point leftBottom = sortedPoints.get(0);
        Point leftTop = sortedPoints.get(1);
        Point rightBottom = sortedPoints.get(2);
        Point rightTop = sortedPoints.get(3);

        if (leftBottom.getY() != rightBottom.getY() || leftTop.getY() != rightTop.getY()) {
            throw new IllegalArgumentException(INVALID_CHECK_MESSAGE);
        }
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();
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
