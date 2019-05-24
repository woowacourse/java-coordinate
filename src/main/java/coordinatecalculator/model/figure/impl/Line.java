package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public class Line extends PlaneFigure implements Comparable<Line> {
    private static final String PRE_MESSAGE = "두 점 사이의 거리는 : ";

    public Line(List<Coordinate> coordinates) {
        super(coordinates);
    }

    double calculateGradient() {
        Coordinate coordinateA = coordinates.get(0);
        Coordinate coordinateB = coordinates.get(1);

        try {
            double gradient = (double) (coordinateA.getY() - coordinateB.getY())
                    / (coordinateA.getX() - coordinateB.getX());
            return (Math.abs(gradient) == 0.0) ? 0.0 : gradient;
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
        Coordinate coordinateA = coordinates.get(0);
        Coordinate coordinateB = coordinates.get(1);

        int dx = coordinateA.getX() - coordinateB.getX();
        int dy = coordinateA.getY() - coordinateB.getY();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public String getPreMessage() {
        return PRE_MESSAGE;
    }
}
