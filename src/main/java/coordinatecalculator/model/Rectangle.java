package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rectangle implements Figure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int GET_TWO_POINTS_SIZE = 2;

    private double area;

    public Rectangle(final Points points) {
        this.area = calculateResult(points);
    }

    private List<Point> getDifferentPoints(final Points points) {
        List<Point> differPoints = new ArrayList<>();
        differPoints.add(points.getPoint(FIRST_POINT));

        points.getPoints().stream()
                .filter(points.getPoint(FIRST_POINT)::isDifferentXYValue)
                .forEach(differPoints::add);
        return differPoints;
    }

    private List<Point> validateRectangle(List<Point> differentPoints) {
        if (differentPoints.size() != GET_TWO_POINTS_SIZE) {
            throw new IllegalArgumentException("옯바른 직사각형 형식이 아닙니다.");
        }
        return differentPoints;
    }

    @Override
    public double getResult() {
        return area;
    }

    @Override
    public double calculateResult(final Points points) {
        List<Point> differentPoints = validateRectangle(getDifferentPoints(points));
        Point firstPoint = differentPoints.get(FIRST_POINT);
        Point secondPoint = differentPoints.get(SECOND_POINT);

        return Math.abs(firstPoint.getxPoint().subtract(secondPoint.getxPoint().getValue())
                * firstPoint.getyPoint().subtract(secondPoint.getyPoint().getValue()));
    }

    @Override
    public String toString() {
        return "사각형 넓이는 " + String.format("%.3f", getResult());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area);
    }
}
