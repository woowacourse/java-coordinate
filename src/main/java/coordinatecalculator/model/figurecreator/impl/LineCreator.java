package coordinatecalculator.model.figurecreator.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Line;
import coordinatecalculator.model.figurecreator.FigureCreator;

import java.util.List;

public class LineCreator implements FigureCreator {
    @Override
    public Line create(List<Coordinate> coordinates) {
        return new Line(coordinates);
    }
}
