package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.coordinate.CoordinateCalculator;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public class Line extends PlaneFigure implements Comparable<Line> {
    private static final double PARALLEL_X_AXIS_GRADIENT = 0.0;

    public Line(List<Coordinate> coordinates) {
        super(coordinates);
    }

    public double calculateGradient() {
        Coordinate a = coordinates.get(0);
        Coordinate b = coordinates.get(1);

        try {
            double gradient = CoordinateCalculator.gradient(a, b);
            return (Math.abs(gradient) == PARALLEL_X_AXIS_GRADIENT)? PARALLEL_X_AXIS_GRADIENT : gradient;
        } catch (ArithmeticException e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public double calculateArea() {
        Coordinate a = coordinates.get(0);
        Coordinate b = coordinates.get(1);

        return CoordinateCalculator.lineLength(a, b);
    }

    @Override
    public String resultMessage() {
        return "두 점 사이의 거리는 : ";
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }
}
