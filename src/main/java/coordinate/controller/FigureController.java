package coordinate.controller;

import coordinate.domain.Line;
import coordinate.domain.Points;

public class FigureController {
    public Line getFigure(Points points) {
        if (points.getSize() == 2) {
            return Line.create(points.pointsByIndex(0), points.pointsByIndex(1));
        }

        return null;
    }
}
