package coordinatecalculator.model;

import java.util.List;

public class Triangle extends PlaneFigure {

    public Triangle(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public double calculateArea() {
        double squaredA = Math.pow(lines.get(0).getLength(), 2);
        double squaredB = Math.pow(lines.get(1).getLength(), 2);
        double squaredC = Math.pow(lines.get(2).getLength(), 2);

        return (double) 1 / 4 * Math.sqrt(4 * squaredA * squaredB
                - Math.pow(squaredA + squaredB - squaredC, 2));
    }
}
