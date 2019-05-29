package coordinatecalculator.model.figurecreator.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Rectangle;
import coordinatecalculator.model.figurecreator.FigureCreator;

import java.util.List;

public class RectangleCreator implements FigureCreator {
    @Override
    public Rectangle create(List<Coordinate> coordinates) {
        return new Rectangle(coordinates);
    }
}
