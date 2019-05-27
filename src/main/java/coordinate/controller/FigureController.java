package coordinate.controller;

import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.domain.Rectangle;

public class FigureController {
    public Line getFigure(Points points) {
        return Line.create(points.pointsByIndex(0), points.pointsByIndex(1));
    }

    public Rectangle getRectangle(Points points) {
        return Rectangle.create(points.pointsByIndex(0), points.pointsByIndex(1), points.pointsByIndex(2), points.pointsByIndex(3));
    }
}
