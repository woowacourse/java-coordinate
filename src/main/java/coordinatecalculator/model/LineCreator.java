package coordinatecalculator.model;

import java.util.List;

public class LineCreator implements FigureCreator {
    @Override
    public Line create(List<Coordinate> coordinates) {
        return new Line(coordinates);
    }
}
