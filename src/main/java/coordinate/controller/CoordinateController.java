package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.domain.PointsGenerator;
import coordinate.domain.Shape;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        String input = InputView.inputCoordinate();

        Figure figure = Shape.createFigure(PointsGenerator.generate(input));

        OutputView.printCoordinateSystem(figure);
        OutputView.printResult(figure);
    }
}
