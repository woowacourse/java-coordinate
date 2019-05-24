package coordinatecalculator.model;

import java.util.List;

public interface FigureCreator {
    PlaneFigure create(List<Coordinate> coordinates);
}
