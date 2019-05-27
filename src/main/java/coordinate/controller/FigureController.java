package coordinate.controller;

import coordinate.domain.*;

public class FigureController {
    public ResultPrintable getFigure(Points points) {
        return PrintableEnum.valueOf(points.getSize()).create(points);
    }
}
