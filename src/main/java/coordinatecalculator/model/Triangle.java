package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Figure {
    private List<Line> lines;

    public Triangle(List<Coordinate> coordinates) {
        lines = new ArrayList<>();

        for (int i = 0; i < coordinates.size() - 1; i++) {
            for (int j = i + 1; j < coordinates.size(); j++) {
                lines.add(new Line(coordinates.get(i), coordinates.get(j)));
            }
        }
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
