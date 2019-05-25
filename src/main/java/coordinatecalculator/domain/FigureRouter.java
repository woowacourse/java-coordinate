package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

public class FigureRouter {
    public static Figure routing(Points points) {
        return NumberOfPoints.selectFigure(points);
    }
}