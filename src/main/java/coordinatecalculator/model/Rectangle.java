package coordinatecalculator.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rectangle extends Figure {
    private Set<Integer> xValues;
    private Set<Integer> yValues;

    public Rectangle(List<Coordinate> coordinates) {
        Set<Integer> xValues = getXValues(coordinates);
        Set<Integer> yValues = getYValues(coordinates);

        checkIsRectangle(xValues, yValues);

        this.xValues = xValues;
        this.yValues = yValues;
    }

    private void checkIsRectangle(Set<Integer> xValues, Set<Integer> yValues) {
        if (xValues.size() != 2 || yValues.size() != 2) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private Set<Integer> getXValues(List<Coordinate> coordinates) {
        Set<Integer> values = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            values.add(coordinate.getXValue());
        }
        return values;
    }

    private Set<Integer> getYValues(List<Coordinate> coordinates) {
        Set<Integer> values = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            values.add(coordinate.getYValue());
        }
        return values;
    }

    private double calculateLength(Set<Integer> values) {
        return values.stream().reduce(0, (a, b) -> Math.abs(a - b));
    }

    @Override
    public double calculateArea() {
        return calculateLength(xValues) * calculateLength(yValues);
    }
}
