package coordinatecalculator.model;

import java.util.List;

public class Line extends PlaneFigure implements Comparable<Line> {
    public Line(List<Coordinate> coordinates) {
        super(coordinates);
    }

    public double calculateGradient() {
        Coordinate coordinateA = coordinates.get(0);
        Coordinate coordinateB = coordinates.get(1);

        try {
            double gradient = (double) (coordinateA.getY() - coordinateB.getY())
                    / (coordinateA.getX() - coordinateB.getX());
            return (Math.abs(gradient) == 0.0)? 0.0 : gradient;
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

        int dx = Math.abs(coordinateA.getX() - coordinateB.getX());
        int dy = Math.abs(coordinateA.getY() - coordinateB.getY());
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public String resultMessage() {
        return "두 점 사이의 거리는 : ";
    }
}
