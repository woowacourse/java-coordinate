package location.controller;

import location.domain.*;
import location.view.InputView;
import location.view.ShapeMsgEnum;

public class CoordinateController {

    public static void main(String[] args) {
        Points points = new Points(InputView.inputCoordinate());
        Shape shape = ShapeMaker.create(points);
        System.out.println(ShapeMsgEnum.valueOf(points.size()) + shape.calculate());
    }
}
