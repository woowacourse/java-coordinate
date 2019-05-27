package coordinate.controller;

import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.domain.Rectangle;

public class FigureController {
    public Line getFigure(Points points) {
        return Line.create(points);
    }

    public Rectangle getRectangle(Points points) {
        return Rectangle.create(points);
    }
}
