package coordinate;

import coordinate.controller.FigureController;
import coordinate.controller.InputViewController;
import coordinate.controller.OutputViewController;
import coordinate.domain.Line;
import coordinate.domain.Points;
import coordinate.view.InputView;
import coordinate.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputViewController inputViewController = new InputViewController(new InputView());
        Points points = inputViewController.inputCoordinates();

        FigureController figureController = new FigureController();
        Line line = figureController.getFigure(points);

        OutputViewController outputViewController = new OutputViewController(new OutputView(), line);
        outputViewController.printCoordinatesBoard();
        outputViewController.printFigureInfo();
    }
}
