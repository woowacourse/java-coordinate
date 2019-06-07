package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
    private static final String INVALID_CHECK_MESSAGE = "직사각형이 아닙니다. 다시 입력해 주세요";
    private static final String TRIANGLE_RESULT_MESSAGE = "사각형 넓이는 ";
    private static final int SAME_POSITION = 0;

    private final Points points;

    private Rectangle(Points points) {
        this.points = points;

        checkValidRectangle();
    }

    public static Rectangle newInstance(Points points) {
        return new Rectangle(points);
    }

    private void checkValidRectangle() {
        List<Point> points = this.points.getSortedPoints();

        if (matchesPoint(points)) {
            throw new IllegalArgumentException(INVALID_CHECK_MESSAGE);
        }
    }

    private boolean matchesPoint(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);

        return !(p1.differenceByX(p2) == SAME_POSITION && p3.differenceByX(p4) == SAME_POSITION
                && p1.differenceByY(p3) == SAME_POSITION && p2.differenceByY(p4) == SAME_POSITION);
    }

    @Override
    public double calculateResult() {
        List<Point> points = Collections.unmodifiableList(this.points.getSortedPoints());
        return points.get(0).differenceByY(points.get(1)) * points.get(2).differenceByX(points.get(0));
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
