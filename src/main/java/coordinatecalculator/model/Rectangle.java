package coordinatecalculator.model;

import java.util.HashSet;
import java.util.Set;

public class Rectangle extends AbstractFigure{
    private static final int VALIDATING_NUMBER = 2;

    private static final int NUMBER_OF_POINTS_IN_RECTANGLE = 4;

    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int THIRD_POINT_INDEX = 2;


    public Rectangle(Points points) {
        super(points);
        validateRectangle(points);
    }

    private void validateRectangle(Points points) {
        if (points.getPointCount() != NUMBER_OF_POINTS_IN_RECTANGLE) {
            throw new IllegalArgumentException();
        }
        if (collectUniqueXValues().size() != VALIDATING_NUMBER || collectUniqueYValues().size() != VALIDATING_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private Set<Value> collectUniqueXValues() {
        Set<Value> xValues = new HashSet<>();
        for (Point currentPoint : points.retrivePoints()) {
            xValues.add(currentPoint.getXValue());
        }
        return xValues;
    }

    private Set<Value> collectUniqueYValues() {
        Set<Value> yValues = new HashSet<>();
        for (Point currentPoint : points.retrivePoints()) {
            yValues.add(currentPoint.getYValue());
        }
        return yValues;
    }


    @Override
    public double area() {
        double firstLine = distance(FIRST_POINT_INDEX, SECOND_POINT_INDEX);
        double secondLine = distance(FIRST_POINT_INDEX, THIRD_POINT_INDEX);
        return firstLine * secondLine;
    }
}
