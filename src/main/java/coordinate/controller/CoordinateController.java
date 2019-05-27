package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.domain.PointsGenerator;
import coordinate.domain.Shape;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class CoordinateController {
    public static void main(String[] args) {
        Figure figure = setUpFigure();

        OutputView.printCoordinateSystem(figure);
        OutputView.printResult(figure);
    }

    private static Figure setUpFigure() {
        try {
            String input = InputView.inputCoordinate();
            return Shape.createFigure(PointsGenerator.generate(input));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return setUpFigure();
        }
    }
}
