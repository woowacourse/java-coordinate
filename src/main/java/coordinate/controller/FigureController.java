package coordinate.controller;

import coordinate.domain.*;

public class FigureController {
    public ResultPrintable getFigure(Points points) {
        if (points.getSize() == 3) {
            return Triangle.create(points);
        }

        if (points.getSize() == 4) {
            return Rectangle.create(points);
        }

        if (points.getSize() == 2) {
            return Line.create(points);
        }

        return null;
    }
}
