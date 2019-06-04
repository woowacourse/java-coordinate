package coordinate.controller;

import coordinate.domain.*;

public class FigureController {
    public ResultPrintable getFigure(Points points) {
        return FigureEnum.valueOf(points.getSize()).create(points);
    }
}
