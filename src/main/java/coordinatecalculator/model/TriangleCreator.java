package coordinatecalculator.model;

import java.util.List;

public class TriangleCreator implements FigureCreator {
    @Override
    public Triangle create(List<Coordinate> coordinates) {
        return new Triangle(coordinates);
    }
}
