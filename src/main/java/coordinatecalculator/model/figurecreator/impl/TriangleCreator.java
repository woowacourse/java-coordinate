package coordinatecalculator.model.figurecreator.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Triangle;
import coordinatecalculator.model.figurecreator.FigureCreator;

import java.util.List;

public class TriangleCreator implements FigureCreator {
    @Override
    public Triangle create(List<Coordinate> coordinates) {
        return new Triangle(coordinates);
    }
}
