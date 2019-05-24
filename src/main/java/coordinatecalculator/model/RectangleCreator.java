package coordinatecalculator.model;

import java.util.List;

public class RectangleCreator implements FigureCreator {
    @Override
    public Rectangle create(List<Coordinate> coordinates) {
        return new Rectangle(coordinates);
    }
}
