package location.controller;

import location.domain.*;
import location.view.InputView;
import location.view.OutputView;

public class CoordinateController {

    public static void main(String[] args) {
        Points points = new Points(InputView.inputCoordinate());
        Figure figure = FigureMaker.create(points);
        OutputView outputView = new OutputView(points.size(), figure.calculate());
        outputView.printResultMap(points);
        outputView.printResultText();
    }
}
