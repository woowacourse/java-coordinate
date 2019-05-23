package coordinatecalculator.model;

import java.util.List;

public abstract class PlaneFigure implements Figure {
    protected final Coordinates coordinates;

    protected PlaneFigure(List<Coordinate> coordinates) {
        this.coordinates = new Coordinates(coordinates);
    }

    public abstract String resultMessage();
}
