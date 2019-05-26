package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Rectangle extends AbstractFigure {
    private static final String ERROR_INVALID_RECTANGLE = "직사각형 모양이 아닙니다.";
    private static final int NUM_OF_TYPES_OF_RECTANGLE_COORDINATES = 2;

    Rectangle(List<Point> points) {
        super(points);
        checkRectangleWith(points);
    }

    private void checkRectangleWith(List<Point> points) {
        Set<Integer> xValuesOfPoints = points.stream()
                .map(Point::getX)
                .collect(toSet());
        Set<Integer> yValuesOfPoints = points.stream()
                .map(Point::getY)
                .collect(toSet());
        if (hasNotTwoPoints(xValuesOfPoints) || hasNotTwoPoints(yValuesOfPoints)) {
            throw new IllegalArgumentException(ERROR_INVALID_RECTANGLE);
        }
    }

    private boolean hasNotTwoPoints(Set<Integer> valuesOfPoints) {
        return valuesOfPoints.size() != NUM_OF_TYPES_OF_RECTANGLE_COORDINATES;
    }

    @Override
    public double area() {
        int differenceOfXValues = calculateDifference(getPoints().stream()
                .map(Point::getX)
                .collect(toSet()));
        int differenceOfYValues = calculateDifference(getPoints().stream()
                .map(Point::getY)
                .collect(toSet()));

        return (double) (differenceOfXValues * differenceOfYValues);
    }

    private int calculateDifference(Set<Integer> valuesOfPoints) {
        List<Integer> values = new ArrayList<>(valuesOfPoints);
        return Math.abs(values.get(0) - values.get(1));
    }
}
