package coordinate.domain;

import java.util.Objects;

public class Rectangle implements Figure, ResultPrintable {
    private static final String ERROR_SQUARE = "사각형이 아닙니다.";
    private static final String ERROR_POINT_SIZE = "4개의 점이 입력되지 않았습니다.";
    private static final String RESULT_FORMAT = "사각형 넓이는 %.0f";
    private static final int POINT_SIZE = 4;

    private Points points;

    private Rectangle(Points points) throws IllegalArgumentException {
        if (isNotRectangles(points)) {
            throw new IllegalArgumentException(ERROR_SQUARE);
        }

        this.points = points;
    }

    public static Rectangle create(Points points) {
        return new Rectangle(points);
    }

    private boolean isNotRectangles(Points points) {
        if (points.getSize() != POINT_SIZE) {
            throw new IllegalArgumentException(ERROR_POINT_SIZE);
        }

        return !(points.checkX() && points.checkY());
    }

    @Override
    public double getArea() {
        double height = points.getFirstDistance();
        double weight = points.getSecondDistance();

        return height * weight;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    public String getResultMessage() {
        return String.format(RESULT_FORMAT, getArea());
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
