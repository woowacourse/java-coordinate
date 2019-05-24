package coordinatecalculator.model.figurecreator;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.PlaneFigure;

import java.util.List;

public interface FigureCreator {
    PlaneFigure create(List<Coordinate> coordinates);
}
