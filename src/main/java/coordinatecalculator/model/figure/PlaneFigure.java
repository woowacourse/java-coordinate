package coordinatecalculator.model.figure;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.coordinate.Coordinates;

import java.util.List;

public abstract class PlaneFigure implements Figure {
    protected final Coordinates coordinates;

    protected PlaneFigure(List<Coordinate> coordinates) {
        this.coordinates = new Coordinates(coordinates);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public abstract String getPreMessage();
}
