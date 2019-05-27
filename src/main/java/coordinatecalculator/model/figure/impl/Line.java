package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public class Line extends PlaneFigure implements Comparable<Line> {
    private static final String PRE_MESSAGE = "두 점 사이의 거리는 : ";
    private static final int SQUARE = 2;
    private static final int FIRST_COORDINATE = 0;
    private static final int SECOND_COORDINATE = 1;
    private static final double ZERO = 0.0;

    public Line(List<Coordinate> coordinates) {
        super(coordinates);
    }

    public double calculateGradient() {
        Coordinate coordinateA = coordinates.get(FIRST_COORDINATE);
        Coordinate coordinateB = coordinates.get(SECOND_COORDINATE);

        try {
            double gradient = (double) (coordinateA.getY() - coordinateB.getY())
                    / (coordinateA.getX() - coordinateB.getX());
            return (Math.abs(gradient) == ZERO) ? ZERO : gradient;
        } catch (ArithmeticException e) {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(this.calculateArea(), o.calculateArea());
    }

    @Override
    public double calculateArea() {
        Coordinate coordinateA = coordinates.get(FIRST_COORDINATE);
        Coordinate coordinateB = coordinates.get(SECOND_COORDINATE);

        int dx = coordinateA.getX() - coordinateB.getX();
        int dy = coordinateA.getY() - coordinateB.getY();
        return Math.sqrt(Math.pow(dx, SQUARE) + Math.pow(dy, SQUARE));
    }

    @Override
    public String getPreMessage() {
        return PRE_MESSAGE;
    }
}
