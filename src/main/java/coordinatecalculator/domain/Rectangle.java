package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;
import java.util.Objects;

public class Rectangle implements Figure {
    private static final String INVALID_CHECK_MESSAGE = "직사각형이 아닙니다. 다시 입력해 주세요";
    public static final String TRIANGLE_RESULT_MESSAGE = "삼각형 넓이는 ";

    private final Points points;

    public Rectangle(Points points) {
        this.points = points;

        checkValidRectangle();
    }

    private void checkValidRectangle() {
        List<Point> points = this.points.getSortedPoints();

        if (!(points.get(1).getX() == points.get(0).getX() && points.get(3).getX() == points.get(2).getX() && points.get(2).getY() == points.get(0).getY() && points.get(3).getY() == points.get(1).getY())) {
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
        StringBuilder sb = new StringBuilder(TRIANGLE_RESULT_MESSAGE);
        return sb.append(calculateResult()).toString();
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
