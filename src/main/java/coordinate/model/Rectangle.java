package coordinate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.toSet;

public class Rectangle extends AbstractFigure {
    private static final String ERROR_INVALID_RECTANGLE = "직사각형 모양이 아닙니다.";
    private static final String OUTPUT_AREA_OF_RECTANGLE = "사각형의 넓이는 ";
    private static final int NUM_OF_TYPES_OF_RECTANGLE_COORDINATES = 2;

    Rectangle(List<Point> points) {
        super(points);
        checkRectangleWith(points);
    }

    private void checkRectangleWith(List<Point> points) {
        Set<Integer> xValuesOfPoints = convertToUniqueXValues(points);
        Set<Integer> yValuesOfPoints = convertToUniqueYValues(points);

        if (hasNotTwoPoints(xValuesOfPoints) || hasNotTwoPoints(yValuesOfPoints)) {
            throw new IllegalArgumentException(ERROR_INVALID_RECTANGLE);
        }
    }

    private Set<Integer> convertToUniqueXValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getX);
    }

    private Set<Integer> convertToUniqueYValues(List<Point> points) {
        return convertToUniqueValues(points, Point::getY);
    }

    private Set<Integer> convertToUniqueValues(List<Point> points, Function<Point, Integer> function) {
        return points.stream()
                .map(function)
                .collect(toSet());
    }

    private boolean hasNotTwoPoints(Set<Integer> valuesOfPoints) {
        return valuesOfPoints.size() != NUM_OF_TYPES_OF_RECTANGLE_COORDINATES;
    }

    @Override
    public double area() {
        List<Point> points = getPoints();
        int differenceOfXValues = calculateDifference(convertToUniqueXValues(points));
        int differenceOfYValues = calculateDifference(convertToUniqueYValues(points));

        return (double) (differenceOfXValues * differenceOfYValues);
    }

    private int calculateDifference(Set<Integer> valuesOfPoints) {
        List<Integer> values = new ArrayList<>(valuesOfPoints);
        return Math.abs(values.get(0) - values.get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_RECTANGLE + area();
    }
}
