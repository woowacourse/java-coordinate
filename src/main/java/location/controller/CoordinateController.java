package location.controller;

import location.domain.Figure;
import location.domain.FigureMaker;
import location.domain.Points;
import location.view.InputView;
import location.view.OutputView;

public class CoordinateController {

    public static void main(String[] args) {
        Figure figure = inputValidation();
        OutputView outputView = new OutputView(figure.getPoints().size(), figure.calculate());
        outputView.printResultMap(figure.getPoints());
        outputView.printResultText();
    }

    private static Figure inputValidation() {
        try {
            Points points = new Points(InputView.inputCoordinate());
            return FigureMaker.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputValidation();
        }
    }
}
