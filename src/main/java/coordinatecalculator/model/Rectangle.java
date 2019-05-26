package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rectangle implements Figure {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int DEGREE_OF_THIRD_PRECISION = 1000;

    private double area;

    public Rectangle(final Points points) {
        this.area = calculateArea(points);
    }

    private double calculateArea(Points points) {
        List<Point> differentPoints = validateRectangle(getDifferentPoints(points));
        Point firstPoint = differentPoints.get(FIRST_POINT);
        Point secondPoint = differentPoints.get(SECOND_POINT);

        return Math.abs(firstPoint.getxPoint().subtract(secondPoint.getxPoint().getValue())
                * firstPoint.getyPoint().subtract(secondPoint.getyPoint().getValue()));
    }

    private List<Point> getDifferentPoints(final Points points) {
        List<Point> differPoints = new ArrayList<>();
        differPoints.add(points.getPoint(FIRST_POINT));

        points.getPoints().stream()
                .filter(points.getPoint(FIRST_POINT)::isDifferentXYValue)
                .forEach(differPoints::add);
        return differPoints;
    }

    private List<Point> validateRectangle(List<Point> differentPoints){
        if(differentPoints.size() != 2){
            throw new IllegalArgumentException("옯바른 직사각형 형식이 아닙니다.");
        }
        return differentPoints;
    }

    @Override
    public double getResult() {
        return Math.round(area * DEGREE_OF_THIRD_PRECISION) / DEGREE_OF_THIRD_PRECISION;
    }
}
